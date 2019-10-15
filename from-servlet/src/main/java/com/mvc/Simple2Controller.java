package com.mvc;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller("/simple2") // BeanNameUrlHandlerMapping
public class Simple2Controller implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        return new ModelAndView("/WEB-INF/simple.jsp");
        return new ModelAndView("simple"); // ViewResolver의 Prefix와 Suffix로 인해 생략함
    }
}
