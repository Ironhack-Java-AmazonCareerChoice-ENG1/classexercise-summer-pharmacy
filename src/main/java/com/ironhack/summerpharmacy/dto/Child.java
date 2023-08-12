package com.ironhack.summerpharmacy.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Child extends Father {
    private String hobby;

    public Child(String name, String football) {
        super(name);
        this.hobby = football;
    }
}
