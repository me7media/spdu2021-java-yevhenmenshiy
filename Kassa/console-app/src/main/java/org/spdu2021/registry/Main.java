package org.spdu2021.registry;

public class Main {
    public static void main(String[] args) {
        EventsRegistryFactory eventsRegistryFactory = new EventsRegistryFactory();
        EventsRegistry eventsRegistry = eventsRegistryFactory.create();

        eventsRegistry.run();
    }
}
