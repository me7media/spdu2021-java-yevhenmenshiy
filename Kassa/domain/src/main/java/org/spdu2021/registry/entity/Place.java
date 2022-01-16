package org.spdu2021.registry.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Place {

    private final int place;
    private final Event event;
    private final LocalDateTime date;

    public Place(int place, Event event, LocalDateTime date) {
        this.place = place;
        this.event = event;
        this.date = date;
    }
    public int getPlace() {
        return place;
    }

    public Event getEvent() {
        return event;
    }

    public LocalDateTime getDate() {
        return date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place placeObj = (Place) o;
        return Objects.equals(place, placeObj.place)
                && Objects.equals(event, placeObj.event)
                && Objects.equals(date, placeObj.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, event, date);
    }


    @Override
    public String toString() {
        return "Place{" +
                "Event name='" + event.getName() + '\'' +
                ", place=" + place +
                ", date=" + date +
                '}';
    }
}
