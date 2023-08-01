package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.MedicationDto;
import com.ironhack.summerpharmacy.model.Medication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    Medication toEntity (MedicationDto dto);
    MedicationDto toDto (Medication entity);
}
