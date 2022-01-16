package org.spdu2021.registry.ui;

import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;

import java.util.List;

public interface SalesReader {

    List<Sale> readSales(Event event);

}