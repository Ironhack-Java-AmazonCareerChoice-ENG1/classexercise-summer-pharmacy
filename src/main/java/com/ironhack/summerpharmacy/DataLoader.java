package com.ironhack.summerpharmacy;

import com.ironhack.summerpharmacy.mapper.BasketMapper;
import com.ironhack.summerpharmacy.mapper.ChildMapper;
import com.ironhack.summerpharmacy.model.Basket;
import com.ironhack.summerpharmacy.model.Child;
import com.ironhack.summerpharmacy.model.Mango;
import com.ironhack.summerpharmacy.model.Tomato;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final ChildMapper childMapper;

    private final BasketMapper basketMapper;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        var child = new Child("John", "Football");

        var childDto = childMapper.toChildDto(child);
        System.out.println(childDto);

        var basket = new Basket();
        var tomato = new Tomato();
        tomato.setName("Tomato");
        var mango = new Mango();
        mango.setName("Mango");
        var fruits = List.of(tomato, mango);
        basket.setFruits(fruits);

        var basketDto = basketMapper.toBasketDto(basket);
        System.out.println(basketDto);

    }
}
