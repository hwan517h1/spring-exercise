package com.spring.profile;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// Spring 4.2 이전
//@Component
//public class Listener implements ApplicationListener<Event> {
//    @Override
//    public void onApplicationEvent(Event event) {
//        System.out.println("이벤트 발생 비용: " + event.getData());
//    }
//}

// Spring 4.2 이후
@Component
public class Listener {

    @EventListener
    public void handler(Event event) {
        System.out.println("이벤트 발생 비용: " + event.getData());
    }
}
