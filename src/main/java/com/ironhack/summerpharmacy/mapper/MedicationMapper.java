package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.MedicationDto;
import com.ironhack.summerpharmacy.model.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING) // uses = {}
public interface MedicationMapper {
    Medication toEntity (MedicationDto dto);
    MedicationDto toDto (Medication entity);
}
