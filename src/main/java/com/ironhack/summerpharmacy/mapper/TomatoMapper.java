package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.TomatoDto;
import com.ironhack.summerpharmacy.model.Tomato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TomatoMapper {
    Tomato toTomato(TomatoDto dto);

    TomatoDto toTomatoDto(Tomato tomato);
}
