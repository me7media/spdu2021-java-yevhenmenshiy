package org.spdu2021.registry;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;
import org.spdu2021.registry.logger.Logger;
import org.spdu2021.registry.logger.LoggerFactory;
import org.spdu2021.registry.ui.*;

import java.util.*;
import java.util.stream.Collectors;


public class EventsRegistry {
    private static final Logger logger = LoggerFactory.getLogger(EventsRegistry.class);

    private EventsReader eventsReader;
    private EventsPrinter eventsPrinter;
    private SalesReader salesReader;
    private SalesPrinter salesPrinter;


    public EventsRegistry(
            EventsReader eventsReader,
            EventsPrinter eventsPrinter,
            SalesReader salesReader,
            SalesPrinter salesPrinter
    ) {
        this.eventsReader = eventsReader;
        this.eventsPrinter = eventsPrinter;
        this.salesReader = salesReader;
        this.salesPrinter = salesPrinter;
    }


    public void run() {
        List<Event> events = this.eventsReader.readEvents();
        eventDateSorter(events);
        this.eventsPrinter.printEvents(events);

       sales(events);

    }

    private void sales(List<Event> events) {
        List<Sale> sales = new ArrayList<>();

        for (Event event : events) {
            sales.addAll(this.salesReader.readSales(event));
        }

        Map<String, List<Sale>> map = groupByCustomer(sales);

        map.forEach((customerName, salesList) -> {
            eventNameSorter(salesList);
            this.salesPrinter.printSales(salesList, customerName);
        });
    }

    private void eventDateSorter(List<Event> events) {
        Collections.sort(events, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
    }

    private Map<String, List<Sale>> groupByCustomer(List<Sale> sales) {
        return sales.stream().collect(Collectors.groupingBy(Sale::getCustomerFullName));
    }

    private void eventNameSorter(List<Sale> sales) {
        Collections.sort(sales, (o1, o2) -> o1.getEvent().getName().compareTo(o2.getEvent().getName()));
    }

}