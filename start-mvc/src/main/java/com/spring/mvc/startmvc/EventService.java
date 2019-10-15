package com.spring.mvc.startmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("스프링 핵심 실습")
                .limit(10)
                .start(LocalDateTime.of(2019, 7, 1, 0, 0))
                .end(LocalDateTime.of(2019,7,1,12,0))
                .build();

        Event event2 = Event.builder()
                .name("스프링 MVC 실습")
                .limit(10)
                .start(LocalDateTime.of(2019, 7, 1, 0, 0))
                .end(LocalDateTime.of(2019,7,1,12,0))
                .build();

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        return events;
    }
}
