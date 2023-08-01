package com.ironhack.summerpharmacy.controller;

import com.ironhack.summerpharmacy.model.Medication;
import com.ironhack.summerpharmacy.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medications")
@RequiredArgsConstructor
public class MedicationController {


    private final MedicationService medicationService;

    @GetMapping
    public List<Medication> findAll(){
        return medicationService.findAll();
    }

    @PostMapping
    public Medication create(@RequestBody Medication medication){
        return medicationService.addMedication(medication);
    }



}
