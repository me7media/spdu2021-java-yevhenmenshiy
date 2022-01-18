package org.spdu2021.registry.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class SaleTest {
    private Sale sale;
    private Event event;

    private final int places = 1;
    private final int sales = 100;
    private final int price = 99;
    private final LocalDateTime date = LocalDateTime.now();

    @BeforeMethod
    public void setUp() {
        event = new Event("name", sales, price, date);
        sale = new Sale(event, places, places * price, date, "Don" , "Huan");
    }

    @Test
    public void getPlacesTest() {
        assertEquals(sale.getPlaces(), 1);
    }

    @Test
    public void getTotalPriceTest() {
        assertEquals(sale.getTotalPrice(), sale.getPlaces()*price);
    }

    @Test
    public void getEventTest() {
        assertEquals(sale.getEvent(), event);
    }

    @Test
    public void getEventNameTest() {
        assertEquals(event.getName(), sale.getEvent().getName());
    }

    @Test
    public void getDateTest() {
        assertEquals(sale.getSaleDate(), date);
    }

    @Test
    public void getFullName() {
        assertEquals(sale.getCustomerFullName(), "Don Huan");
    }
}