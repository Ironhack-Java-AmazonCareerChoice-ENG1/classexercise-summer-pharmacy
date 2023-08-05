package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.OrderDto;
import com.ironhack.summerpharmacy.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                MedicationMapper.class
        })
public interface OrderMapper {
    OrderDto toDto(Order order);

    @Mapping(target = "id", ignore = true)
    Order toEntity(OrderDto orderDto);
}
