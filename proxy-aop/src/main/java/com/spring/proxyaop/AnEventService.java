package com.spring.proxyaop;

import org.springframework.stereotype.Service;

@Service
public class AnEventService implements EventService {

    @Logging
    @Override
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("An event created.");
    }

    @Logging
    @Override
    public void publishEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("An event published.");
    }

    @Override
    public void deleteEvent() {
        System.out.println("An event deleted.");
    }
}
