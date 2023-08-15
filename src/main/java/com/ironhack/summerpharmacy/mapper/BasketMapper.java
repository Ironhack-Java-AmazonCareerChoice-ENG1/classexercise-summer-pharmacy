package com.ironhack.summerpharmacy.mapper;

import com.ironhack.summerpharmacy.dto.BasketDto;
import com.ironhack.summerpharmacy.dto.FruitDto;
import com.ironhack.summerpharmacy.dto.MangoDto;
import com.ironhack.summerpharmacy.dto.TomatoDto;
import com.ironhack.summerpharmacy.model.Basket;
import com.ironhack.summerpharmacy.model.Fruit;
import com.ironhack.summerpharmacy.model.Mango;
import com.ironhack.summerpharmacy.model.Tomato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MangoMapper.class, TomatoMapper.class})
public interface BasketMapper {
    default FruitDto fruitToFruitDto(Fruit product) {
        if (product instanceof Mango) {
            return Mappers.getMapper(MangoMapper.class).toMangoDto((Mango) product);
        } else if (product instanceof Tomato) {
            return Mappers.getMapper(TomatoMapper.class).toTomatoDto((Tomato) product);
        }
        throw new IllegalArgumentException("Product type not supported: " + product.getClass().getName());
    }

    default Fruit fruitDtoToFruit(FruitDto product) {
        if (product instanceof MangoDto) {
            return Mappers.getMapper(MangoMapper.class).toMango((MangoDto) product);
        } else if (product instanceof TomatoDto) {
            return Mappers.getMapper(TomatoMapper.class).toTomato((TomatoDto) product);
        }
        throw new IllegalArgumentException("Product type not supported: " + product.getClass().getName());
    }

    @Named("mapProductList")
    default List<FruitDto> mapProductList(List<Fruit> products) {
        return products.stream()
                .map(this::fruitToFruitDto)
                .toList();
    }

    @Named("mapProductDtoList")
    default List<Fruit> mapProductDTOList(List<FruitDto> productDTOs) {
        return productDTOs.stream()
                .map(this::fruitDtoToFruit)
                .toList();
    }

    @Mapping(source = "fruits", target = "fruits", qualifiedByName = "mapProductDtoList")
    Basket toBasket(BasketDto dto);

    @Mapping(source = "fruits", target = "fruits", qualifiedByName = "mapProductList")
    BasketDto toBasketDto(Basket basket);
}
