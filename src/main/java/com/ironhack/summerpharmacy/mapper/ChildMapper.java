package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.Child;
import com.ironhack.summerpharmacy.dto.ChildDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildMapper {
    Child toChild(ChildDto dto);

    ChildDto toChildDto(Child child);
}
