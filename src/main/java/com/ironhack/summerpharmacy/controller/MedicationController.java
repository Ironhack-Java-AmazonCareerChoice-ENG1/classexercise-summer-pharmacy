package com.ironhack.summerpharmacy.controller;

import com.ironhack.summerpharmacy.dto.MedicationDto;
import com.ironhack.summerpharmacy.service.MedicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medications")
@RequiredArgsConstructor
public class MedicationController {


    private final MedicationService medicationService;

    @GetMapping
    public List<MedicationDto> findAll() {
        return medicationService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicationDto create(@RequestBody @Valid MedicationDto medicationDto) {
        return medicationService.addMedication(medicationDto);

    }

    @PutMapping("/{id}")
    public MedicationDto update(@PathVariable Long id, @RequestBody @Valid MedicationDto medicationDto) {
        return medicationService.updateMedication(id, medicationDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        medicationService.deleteMedication(id);
    }


}
