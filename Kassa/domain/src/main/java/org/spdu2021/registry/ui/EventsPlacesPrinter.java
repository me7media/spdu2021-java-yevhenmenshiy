package org.spdu2021.registry.ui;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Place;

import java.util.List;
import java.util.Map;

public interface EventsPlacesPrinter {
    void printEventsPlaces(Map<Event, List<Place>> eventsPlaces);
}
