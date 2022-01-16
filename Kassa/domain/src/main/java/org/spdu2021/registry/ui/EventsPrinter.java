package org.spdu2021.registry.ui;

import org.spdu2021.registry.entity.Event;

import java.util.List;

public interface EventsPrinter {
    void printEvents(List<Event> events);
}
