package com.spring.proxyaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
//@Service
//public class ProxyAnEventService implements EventService{
//
//    @Autowired
//    AnEventService anEventService;
//
//    @Override
//    public void createEvent() {
//        long start = System.currentTimeMillis();
//        anEventService.createEvent();
//        System.out.println(System.currentTimeMillis() - start);
//    }
//
//    @Override
//    public void publishEvent() {
//        long start = System.currentTimeMillis();
//        anEventService.publishEvent();
//        System.out.println(System.currentTimeMillis() - start);
//    }
//
//    @Override
//    public void deleteEvent() {
//        anEventService.deleteEvent();
//    }
//}
