package org.spdu2021.registry.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Table
@Entity(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "event_id", nullable = false, insertable = false, updatable = false)
    private Event event;

    @JsonProperty("event_id")
    private Long event_id;

    @Min(1)
    @Max(5000)
    private Integer places;

    @Min(1)
    private Integer totalPrice;

    private LocalDateTime saleDate;

    @Size(min = 4, max = 25)
    @NotBlank(message = "Customer First Name is empty!")
    private String customerFirstName;

    @Size(min = 4, max = 25)
    @NotBlank(message = "Customer Last Name is empty!")
    private String customerLastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", event=" + event +
                ", event_id=" + event_id +
                ", places=" + places +
                ", totalPrice=" + totalPrice +
                ", saleDate=" + saleDate +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                '}';
    }
}
