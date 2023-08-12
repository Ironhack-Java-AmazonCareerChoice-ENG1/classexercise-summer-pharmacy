package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.ChildDto;
import com.ironhack.summerpharmacy.model.Child;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChildMapper {
    Child toChild(ChildDto dto);

    ChildDto toChildDto(Child child);
}
