package org.spdu2021.registry.ui.common;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.ui.interfaces.EventsPrinter;

import java.util.List;

import static java.lang.System.out;

public class CommonEventsPrinter implements EventsPrinter {

    @Override
    public void printEvents(List<Event> events) {
        if (!events.isEmpty()) {

            String leftAlignFormat = "| %-20s | %-20s |%n";
            String tableDash = "+----------------------+----------------------+%n";
            out.format(tableDash);
            out.format("| Name                 | Date                 |%n");
            out.format(tableDash);

            for (Event event : events) {
                out.format(leftAlignFormat,
                        event.getName(),
                        event.getDate()
                );
            }

            out.format(tableDash);

        }
    }
}
