package com.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServletController {

    @Autowired
    ServletService ServletService;

    @GetMapping("/practice")
    @ResponseBody
    public String practice() {
        return "Subject: " + ServletService.getSubject();
    }

    @GetMapping("/sample1")
    public String sample1() {
        return "sample1"; // ServletConfiguration.Custom ViewResolver의 조건 때문에
    }
}
