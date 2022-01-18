package org.spdu2021.registry.web.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table
@Entity(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is empty!")
    @Size(min = 5, max = 25)
    private String name;

    @Size(min = 5,max = 5000)
    private Integer places;

    @Size(min = 1)
    private Integer price;

    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPlaces() {
        return places;
    }

    public Integer getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", places=" + places +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
