package org.spdu2021.registry.ui.auto;

import org.spdu2021.registry.EventsRegistry;
import org.spdu2021.registry.entity.Event;
import org.spdu2021.registry.entity.Sale;
import org.spdu2021.registry.logger.Logger;
import org.spdu2021.registry.logger.LoggerFactory;
import org.spdu2021.registry.ui.SalesReader;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AutoSalesReader implements SalesReader {

    private static final Logger logger = LoggerFactory.getLogger(AutoSalesReader.class);

    String[] names = {
            "Anna",
            "Mary",
            "Tomas",
            "Linda",
            "Andrey",
            "Peter",
            "Natalia",
            "Vladimir",
            "Nikolaus",
            "Karlos",
            "Robert"
    };
    String[] alfabet = {
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K"
    };
    Random random = new Random();

    @Override
    public List<Sale> readSales(Event event) {
        List<Sale> sales = new ArrayList<>();
        makeRandomSales(sales, event);
        return sales;
    }

    private void makeRandomSales(List<Sale> sales, Event event) {

        int placesCount = randomPlacesCount(event);
        LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Sale sale = new Sale(
                event,
                placesCount,
                placesCount * event.getPrice(),
                date,
                randomFirstName(),
                randomLastName()
        );
        sales.add(sale);
    }

    private int randomPlacesCount(Event event) {
        return random.nextInt(event.getPlaces());
    }

    private String randomLastName() {
        int i = random.nextInt(names.length);
        return names[i];
    }

    private String randomFirstName() {
        int i = random.nextInt(alfabet.length);
        return alfabet[i];
    }
}
