package com.mvc;

import org.springframework.stereotype.Service;

@Service
public class MvcService {

    public String getContent() {
        return "Servlet with Spring 2: MVC using DispatcherServlet";
    }
}
