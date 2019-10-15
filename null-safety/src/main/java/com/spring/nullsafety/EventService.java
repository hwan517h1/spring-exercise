package com.spring.nullsafety;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public String createEvent(@NonNull String name) {
        return "Hello, Spring 5!";
    }
}
