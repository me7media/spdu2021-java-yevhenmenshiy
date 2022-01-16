package org.spdu2021.registry.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.Assert.*;

public class PlaceTest {
    public Place place;
    public Event event;

    private final int places = 100;
    private final LocalDateTime date = LocalDateTime.now();

    @BeforeMethod
    public void setUp() {
        event = new Event("name", places, date);
        place = new Place(1, event, date);
    }

    @Test
    public void getPlacesTest() {
        assertEquals(place.getPlace(), 1);
    }

    @Test
    public void getEventTest() {
        assertEquals(place.getEvent(), event);
    }

    @Test
    public void getEventNameTest() {
        assertEquals(event.getName(), place.getEvent().getName());
    }

    @Test
    public void getDateTest() {
        assertEquals(place.getDate(), date);
    }
}