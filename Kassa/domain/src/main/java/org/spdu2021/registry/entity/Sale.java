package org.spdu2021.registry.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Sale {

    private final Event event;
    private final int places;
    private final int totalPrice;
    private final LocalDateTime saleDate;
    private final String customerFirstName;
    private final String customerLastName;

    public Sale(Event event, int places, int totalPrice, LocalDateTime saleDate, String customerFirstName, String customerLastName) {
        this.event = event;
        this.places = places;
        this.totalPrice = totalPrice;
        this.saleDate = saleDate;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    public Event getEvent() {
        return event;
    }

    public int getPlaces() {
        return places;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerFullName() {
        return customerLastName + " " + customerFirstName + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sale sale = (Sale) o;
        return Objects.equals(event, sale.event)
                && Objects.equals(places, sale.places)
                && Objects.equals(totalPrice, sale.totalPrice)
                && Objects.equals(saleDate, sale.saleDate)
                && Objects.equals(customerFirstName, sale.customerFirstName)
                && Objects.equals(customerLastName, sale.customerLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, places, totalPrice, saleDate, customerFirstName, customerLastName);
    }

    @Override
    public String toString() {
        return "Place{" +
                "Event='" + event + '\'' +
                ", places=" + places +
                ", totalPrice=" + totalPrice +
                ", Customer =" + getCustomerFullName() +
                ", saleDate=" + saleDate +
                '}';
    }


}
