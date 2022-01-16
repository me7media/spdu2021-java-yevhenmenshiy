package org.spdu2021.registry.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class EventTest {
    public Event event;

    private final int places = 100;
    private final int price = 99;
    private final LocalDateTime date = LocalDateTime.now();

    @BeforeMethod
    public void setUp() {
        event = new Event("name", places, price, date);
    }

    @Test
    public void getNameTest() {
        assertEquals(event.getName(), "name");
    }

    @Test
    public void getPlacesTest() {
        assertEquals(event.getPlaces(), places);
    }

    @Test
    public void getPriceTest() {
        assertEquals(event.getPrice(), price);
    }

    @Test
    public void getDateTest() {
        assertEquals(event.getDate(), date);
    }
}