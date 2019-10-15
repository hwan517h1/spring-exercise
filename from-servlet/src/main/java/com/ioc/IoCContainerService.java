package com.ioc;

import org.springframework.stereotype.Service;

@Service
public class IoCContainerService {

    public String getContent() {
        return "Servlet with Spring 1: IoC Container";
    }
}
