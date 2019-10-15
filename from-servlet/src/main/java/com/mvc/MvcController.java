package com.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MvcController {

    @Autowired
    MvcService mvcService;

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String hello() {
        return "Hello, Spring! " + mvcService.getContent();
    }

    @GetMapping("/simple1")
    public String simple1() {
//        return "/WEB-INF/simple.jsp"; // ModelAndView 객체 반환
        return "simple";
    }
}
