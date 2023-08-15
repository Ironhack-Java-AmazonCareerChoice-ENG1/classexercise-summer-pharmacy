package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.MangoDto;
import com.ironhack.summerpharmacy.model.Mango;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MangoMapper {
    Mango toMango(MangoDto dto);

    MangoDto toMangoDto(Mango mango);
}
