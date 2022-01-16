package org.spdu2021.registry.ui.auto;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Place;
import org.spdu2021.registry.ui.PlacesReader;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AutoPlacesReader implements PlacesReader {
    
    Random random = new Random();

    @Override
    public List<Place> readPlaces(Event event) {
        List<Place> places = new ArrayList<>();
        int placesCount = randomPlacesCount(event);

        makeRandomPlaces(places, placesCount, event);
        return places;
    }

    private void makeRandomPlaces(List<Place> places, int placesCount, Event event) {
        for (int place = 1; place < placesCount; place++) {
            if(makeRandomPlace()){
                LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
                places.add(new Place(place, event, date));
            }
        }
    }


    private boolean makeRandomPlace() {
        return random.nextBoolean();
    }

    private int randomPlacesCount(Event event) {
        return random.nextInt(event.getPlaces());
    }
}
