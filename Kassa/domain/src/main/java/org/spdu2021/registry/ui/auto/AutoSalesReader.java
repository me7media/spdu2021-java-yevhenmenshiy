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
        int randomAutoSalesCount = randomAutoSalesCount();
        try {
            makeRandomSales(sales, event, randomAutoSalesCount);
        } catch (Exception e) {
            logger.log(e.getMessage() + " for event: " + event.getName());
        }
        return sales;
    }

    private void makeRandomSales(List<Sale> sales, Event event, int randomAutoSalesCount) throws Exception {

        int eventPlacesLeft = event.getPlaces();

        for (int i = 0; i < randomAutoSalesCount; i++) {

            if (eventPlacesLeft <= 0) throw new Exception("No places left");

            int randomPlacesCount = randomPlacesCount(eventPlacesLeft);

            if (randomPlacesCount > eventPlacesLeft) {
                randomPlacesCount = eventPlacesLeft;
            }
            eventPlacesLeft = eventPlacesLeft - randomPlacesCount;

            sales.add(createSale(event, randomPlacesCount));
        }
    }

    private Sale createSale(Event event, int randomPlacesCount) {
        return new Sale(
                event,
                randomPlacesCount,
                randomPlacesCount * event.getPrice(),
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                randomFirstName(),
                randomLastName()
        );
    }

    private int randomAutoSalesCount() {
        return random.nextInt(9) + 1;
    }

    private int randomPlacesCount(int eventPlacesLeft) {
        return random.nextInt(eventPlacesLeft) + 1;
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
