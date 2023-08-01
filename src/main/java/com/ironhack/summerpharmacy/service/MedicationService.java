package com.ironhack.summerpharmacy.service;


import com.ironhack.summerpharmacy.model.Medication;
import com.ironhack.summerpharmacy.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;


    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }


    public List<Medication> findAll(){
        return medicationRepository.findAll();
    }

    public Medication addMedication(Medication medication){
        return medicationRepository.save(medication);
    }
}
