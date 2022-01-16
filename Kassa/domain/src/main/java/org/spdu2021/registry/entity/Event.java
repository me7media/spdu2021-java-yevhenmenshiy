package org.spdu2021.registry.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event implements Serializable {

    private final String name;
    private final int places;
    private final LocalDateTime date;

    public Event(String name, int places, LocalDateTime date) {
        this.name = name;
        this.places = places;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPlaces() {
        return places;
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
        Event event = (Event) o;
        return Objects.equals(name, event.name)
                && Objects.equals(places, event.places)
                && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, places, date);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", places=" + places +
                ", date=" + date +
                '}';
    }
}
