package org.spdu2021.registry.service;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortServiceImpl implements SortService {
    @Override
    public void eventDateSorter(List<Event> events) {
        Collections.sort(events, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));
    }

    @Override
    public Map<String, List<Sale>> groupByCustomer(List<Sale> sales) {
        return sales.stream().collect(Collectors.groupingBy(Sale::getCustomerFullName));
    }

    @Override
    public void eventNameSorter(List<Sale> sales) {
        Collections.sort(sales, (o1, o2) -> o1.getEvent().getName().compareTo(o2.getEvent().getName()));
    }
}
