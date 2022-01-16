package org.spdu2021.registry;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Place;
import org.spdu2021.registry.ui.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsRegistry {
    private List<Event> events;
    private EventsReader eventsReader;
    private EventsPlacesPrinter eventsPlacesPrinter;
    private PlacesReader placesReader;

    public EventsRegistry(
            EventsReader eventsReader,
            PlacesReader placesReader,
            EventsPlacesPrinter eventsPlacesPrinter
    ) {
        this.eventsReader = eventsReader;
        this.placesReader = placesReader;
        this.eventsPlacesPrinter = eventsPlacesPrinter;
    }


    public void setEventsReader(EventsReader eventsReader) {
        this.eventsReader = eventsReader;
    }

    public void setPlacesReader(PlacesReader placesReader) {
        this.placesReader = placesReader;
    }

    public void setEventsPlacesPrinter(EventsPlacesPrinter eventsPlacesPrinter) {
        this.eventsPlacesPrinter = eventsPlacesPrinter;
    }


    public void run() {
        Map<Event, List<Place>> eventsPlacesRegistry = new HashMap<>(Collections.emptyMap());

        events = this.eventsReader.readEvents();

        for (Event event : events) {
            List<Place> places = this.placesReader.readPlaces(event);
            eventsPlacesRegistry.put(event, places);
        }

        this.eventsPlacesPrinter.printEventsPlaces(eventsPlacesRegistry);
    }

}