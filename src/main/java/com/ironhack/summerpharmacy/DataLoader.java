package com.ironhack.summerpharmacy;

import com.ironhack.summerpharmacy.dto.Child;
import com.ironhack.summerpharmacy.mapper.ChildMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final ChildMapper childMapper;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        var child = new Child("John", "Football");

        var childDto = childMapper.toChildDto(child);
        System.out.println(childDto);

    }
}
