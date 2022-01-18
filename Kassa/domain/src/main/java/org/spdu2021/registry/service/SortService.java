package org.spdu2021.registry.service;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;

import java.util.List;
import java.util.Map;

public interface SortService {

    void eventDateSorter(List<Event> events);

    Map<String, List<Sale>> groupByCustomer(List<Sale> sales);

    void eventNameSorter(List<Sale> sales);
}
