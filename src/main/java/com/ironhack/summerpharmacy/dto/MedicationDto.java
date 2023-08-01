package com.ironhack.summerpharmacy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    private long id;

    private String name;

    private String description;

    private double price;

    private String manufacturer;
}
