package org.spdu2021.registry;

import static java.lang.System.out;

import java.util.List;

import org.spdu2021.registry.entity.Sale;
import org.spdu2021.registry.ui.SalesPrinter;


public class CommonSalesPrinter implements SalesPrinter {

    @Override
    public void printSales(List<Sale> sales, String name) {
        if (!sales.isEmpty()) {

            out.println(name);

            String leftAlignFormat = "| %-20s |%n";
            String tableDash = "+----------------------+%n";
            out.format(tableDash);
            out.format("| Event Name           |%n");
            out.format(tableDash);

            for (Sale sale : sales) {
                out.format(leftAlignFormat,
                        sale.getEvent().getName()
                );
            }

            out.format(tableDash);

        }
    }
}
