package org.spdu2021.registry;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Place;
import org.spdu2021.registry.logger.Logger;
import org.spdu2021.registry.logger.LoggerFactory;
import org.spdu2021.registry.ui.EventsPlacesPrinter;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class CommonEventsPlacesPrinter implements EventsPlacesPrinter {
    private static final Logger logger = LoggerFactory.getLogger(CommonEventsPlacesPrinter.class);

    @Override
    public void printEventsPlaces(Map<Event, List<Place>> eventsPlaces) {

        eventsPlaces.forEach((event, places) -> {
            print(event, places);
        });
        
    }
    
    private void print(Event event, List<Place> places){
        if (!places.isEmpty()) {

            out.println(event.getName() + " places:");
            
            String leftAlignFormat = "| %-20s | %-20s |%n";
            String tableDash = "+----------------------+----------------------+%n";
            out.format(tableDash);
            out.format("| Place                | Bye Date             |%n");
            out.format(tableDash);

            for (Place place : places) {
                out.format(leftAlignFormat,
                        place.getPlace(),
                        place.getDate()
                );
            }

            out.format(tableDash);

        }
    }
}
