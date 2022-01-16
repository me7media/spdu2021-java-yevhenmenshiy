package org.spdu2021.registry.ui;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Place;

import java.util.List;

public interface PlacesReader {

    List<Place> readPlaces(Event event);

}