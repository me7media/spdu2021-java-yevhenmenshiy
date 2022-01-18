package org.spdu2021.registry.service;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class SortServiceImplTest {

    private SortService sortService = new SortServiceImpl();
    private List<Event> events = new ArrayList<>();

    private LocalDateTime now;

    @BeforeMethod
    public void setUp() {
        now = LocalDateTime.now();

        events.add(new Event("name1", 10, 10, now.plusDays(1)));
        events.add(new Event("name2", 10, 10, now.plusDays(10)));
        events.add(new Event("name3", 10, 10, now.plusDays(5)));
    }

    @Test
    public void eventDateSorterTest() {
        List<Event> sortEvents = new ArrayList<>(events);

        List<Event> expectedEvents = new ArrayList<>();
        expectedEvents.add(events.get(0));
        expectedEvents.add(events.get(2));
        expectedEvents.add(events.get(1));

        this.sortService.eventDateSorter(sortEvents);

        assertEquals(sortEvents, expectedEvents);
    }

    @Test
    public void groupByCustomerTest() {
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(events.get(1), 1, 20, now, "Me", "Ow"));
        sales.add(new Sale(events.get(2), 2, 20, now, "Me", "Ow"));
        sales.add(new Sale(events.get(0), 3, 20, now, "Me", "Ow"));

        Map<String, List<Sale>> groupByCustomer = this.sortService.groupByCustomer(sales);

        Map<String, List<Sale>> expectedGroupByCustomer = new HashMap<>();
        expectedGroupByCustomer.put("Ow Me.", sales);

        assertEquals(groupByCustomer, expectedGroupByCustomer);
    }

    @Test
    public void eventNameSorterTest() {
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(events.get(1), 1, 20, now, "Me", "Ow"));
        sales.add(new Sale(events.get(2), 2, 20, now, "Me", "Ow"));
        sales.add(new Sale(events.get(0), 3, 20, now, "Me", "Ow"));

        this.sortService.eventNameSorter(sales);

        List<Sale> expectedSales = new ArrayList<>();
        expectedSales.add(new Sale(events.get(0), 3, 20, now, "Me", "Ow"));
        expectedSales.add(new Sale(events.get(1), 1, 20, now, "Me", "Ow"));
        expectedSales.add(new Sale(events.get(2), 2, 20, now, "Me", "Ow"));

        assertEquals(sales, expectedSales);
    }
}