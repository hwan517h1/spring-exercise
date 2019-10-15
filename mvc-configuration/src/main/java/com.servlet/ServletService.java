package com.servlet;

import org.springframework.stereotype.Service;

@Service
public class ServletService {

    public String getSubject() {
        return "Sample1: When NO view exists(RequestMappingHandlerMapping & RequestMappingHandlerAdapter)";
    }
}
