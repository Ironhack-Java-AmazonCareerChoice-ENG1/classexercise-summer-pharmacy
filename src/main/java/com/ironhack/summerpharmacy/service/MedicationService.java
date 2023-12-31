package com.ironhack.summerpharmacy.service;


import com.ironhack.summerpharmacy.dto.MedicationDto;
import com.ironhack.summerpharmacy.exceptions.EntityNotFoundException;
import com.ironhack.summerpharmacy.mapper.MedicationMapper;
import com.ironhack.summerpharmacy.model.Medication;
import com.ironhack.summerpharmacy.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MedicationService {

    private final MedicationRepository medicationRepository;
    private final MedicationMapper mapper;



    public List<MedicationDto> findAll(){

/*        var medicationList = medicationRepository.findAll();
        List<MedicationDto> dtoList = new ArrayList<>();
        for (Medication medication: medicationList) {
            MedicationDto toAdd = mapper.toDto(medication);
            dtoList.add(toAdd);
        }
        return dtoList;*/
        return medicationRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public MedicationDto addMedication(MedicationDto medicationDto){
        Medication medication = mapper.toEntity(medicationDto);
        medicationRepository.save(medication);
        log.info("Medication created: " + medication);
        return mapper.toDto(medication);
    }

    public MedicationDto updateMedication(Long id, MedicationDto medicationDto) {
        if(!medicationRepository.existsById(id)) {
            throw new EntityNotFoundException("No medication with id " + id);
        }
        Medication entity = mapper.toEntity(medicationDto);
        entity.setId(id); // no funny business with ids included in RequestBody
        medicationRepository.save(entity);
        return mapper.toDto(entity);
    }

    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }

    public MedicationDto findById(Long id) {
        return mapper.toDto(medicationRepository.findById(id)
                .orElseThrow( ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Medication with id " + id + " not found.")));
    }
}
