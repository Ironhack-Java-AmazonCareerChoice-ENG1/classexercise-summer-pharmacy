package com.ironhack.summerpharmacy.dto;

import lombok.Data;

import java.util.List;

@Data
public class BasketDto {
    private List<FruitDto> fruits;
}
