package org.spdu2021.registry.ui.auto;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.ui.EventsReader;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoEventsReader implements EventsReader {

    String[] names = {
            "Football",
            "Cinema",
            "Theatre",
            "Event",
    };
    String[] alfabet = {
            "I",
            "II",
            "III",
            "IV",
            "V",
    };
    Random random = new Random();

    @Override
    public List<Event> readEvents() {
        List<Event> events = new ArrayList<>();
        int eventsCount = randomEventsCount();

        makeRandomEvents(events, eventsCount);
        return events;
    }

    private void makeRandomEvents(List<Event> events, int eventsCount) {
        for (int i = 0; i < eventsCount; i++) {
            String name = randomName();

            int places = randomPlaces();
            LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

            events.add(new Event(name, places, date));
        }
    }

    private String randomName() {
        int i = random.nextInt(names.length);
        int j = random.nextInt(alfabet.length);
        return names[i] + " " + alfabet[j] +".";
    }

    private int randomPlaces() {
        return random.nextInt(100);
    }

    private int randomEventsCount() {
        return random.nextInt(10);
    }
}
