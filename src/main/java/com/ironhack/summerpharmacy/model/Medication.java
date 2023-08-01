package com.ironhack.summerpharmacy.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private double price;

    private String manufacturer;

    public Medication(String name, String description, double price, String manufacturer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
    }


}
