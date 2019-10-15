package com.spring.nullsafety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    EventService eventService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent(null);
        // Preferences-Compiler-Configure annotations에서 Spring의 Nullable, NonNull 추가할 것
    }
}
