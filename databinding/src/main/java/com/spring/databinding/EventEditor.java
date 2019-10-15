package com.spring.databinding;

import java.beans.PropertyEditorSupport;

// EventEditor는 thread-safe하지 않으므로 일반적 Bean으로 등록하지 말 것
public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Event event = (Event)getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
