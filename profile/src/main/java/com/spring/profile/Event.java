package com.spring.profile;

import org.springframework.context.ApplicationEvent;

// Spring 4.2 이전
//public class Event extends ApplicationEvent {
//
//    private int data;
//
//    public Event(Object source) {
//        super(source);
//    }
//
//    public Event(Object source, int data ) {
//        super(source);
//        this.data = data;
//    }
//
//    public int getData() {
//        return data;
//    }
//}

// Spring 4.2 이후
public class Event {

    private int data;
    private Object source;

    public Event(Object source, int data ) {
        this.source = source;
        this.data = data;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}