package com.ironhack.summerpharmacy.service;


import com.ironhack.summerpharmacy.dto.MedicationDto;
import com.ironhack.summerpharmacy.model.Medication;
import com.ironhack.summerpharmacy.repository.MedicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MedicationService {

    private final MedicationRepository medicationRepository;


    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }


    public List<MedicationDto> findAll(){

        var medicationList = medicationRepository.findAll();
        List<MedicationDto> dtoList = new ArrayList<>();
        for (Medication medication: medicationList) {
            MedicationDto toAdd = new MedicationDto(medication.getId(),
                medication.getName(),
                medication.getDescription(),
                medication.getPrice(),
                medication.getManufacturer());
            dtoList.add(toAdd);
        }
        return dtoList;
    }

    public MedicationDto addMedication(MedicationDto medicationDto){
        Medication medication = new Medication(medicationDto.getName(),
                medicationDto.getDescription(),
                medicationDto.getPrice(),
                medicationDto.getManufacturer());
        medicationRepository.save(medication);
        log.info("Medication created: " + medication);
        MedicationDto returnVal = new MedicationDto(medication.getId(),
                medication.getName(),
                medication.getDescription(),
                medication.getPrice(),
                medication.getManufacturer());

        return returnVal;
    }
}
