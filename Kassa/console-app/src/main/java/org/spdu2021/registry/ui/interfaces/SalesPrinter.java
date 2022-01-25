package org.spdu2021.registry.ui.interfaces;

import org.spdu2021.registry.entity.Sale;

import java.util.List;

public interface SalesPrinter {
    void printSales(List<Sale> sales, String name);
}
