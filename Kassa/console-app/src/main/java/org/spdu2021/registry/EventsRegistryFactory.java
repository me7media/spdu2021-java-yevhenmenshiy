package org.spdu2021.registry;

import org.spdu2021.registry.service.SortServiceImpl;
import org.spdu2021.registry.ui.auto.AutoEventsReader;
import org.spdu2021.registry.ui.auto.AutoSalesReader;
import org.spdu2021.registry.ui.common.CommonEventsPrinter;
import org.spdu2021.registry.ui.common.CommonSalesPrinter;

public class EventsRegistryFactory {

    public EventsRegistry create() {

        return new EventsRegistry(
                new AutoEventsReader(),
                new CommonEventsPrinter(),

                new AutoSalesReader(),
                new CommonSalesPrinter(),

                new SortServiceImpl()
                );
    }
}
