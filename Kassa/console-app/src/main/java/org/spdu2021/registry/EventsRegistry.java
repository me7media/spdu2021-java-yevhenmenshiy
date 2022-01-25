package org.spdu2021.registry;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;
import org.spdu2021.registry.logger.Logger;
import org.spdu2021.registry.logger.LoggerFactory;
import org.spdu2021.registry.service.SortService;
import org.spdu2021.registry.ui.interfaces.EventsPrinter;
import org.spdu2021.registry.ui.interfaces.EventsReader;
import org.spdu2021.registry.ui.interfaces.SalesPrinter;
import org.spdu2021.registry.ui.interfaces.SalesReader;

import java.util.*;


public class EventsRegistry {
    private static final Logger logger = LoggerFactory.getLogger(EventsRegistry.class);

    private EventsReader eventsReader;
    private EventsPrinter eventsPrinter;
    private SalesReader salesReader;
    private SalesPrinter salesPrinter;
    private SortService sortService;


    public EventsRegistry(
            EventsReader eventsReader,
            EventsPrinter eventsPrinter,
            SalesReader salesReader,
            SalesPrinter salesPrinter,
            SortService sortService
    ) {
        this.eventsReader = eventsReader;
        this.eventsPrinter = eventsPrinter;
        this.salesReader = salesReader;
        this.salesPrinter = salesPrinter;
        this.sortService = sortService;
    }


    public void run() {
        List<Event> events = this.eventsReader.readEvents();
        this.sortService.eventDateSorter(events);
        this.eventsPrinter.printEvents(events);

       sales(events);

    }

    private void sales(List<Event> events) {
        List<Sale> sales = new ArrayList<>();

        for (Event event : events) {
            sales.addAll(this.salesReader.readSales(event));
        }

        Map<String, List<Sale>> salesGroupedByCustomer = this.sortService.groupByCustomer(sales);

        salesGroupedByCustomer.forEach((customerName, salesList) -> {
            this.sortService.eventNameSorter(salesList);
            this.salesPrinter.printSales(salesList, customerName);
        });
    }

}