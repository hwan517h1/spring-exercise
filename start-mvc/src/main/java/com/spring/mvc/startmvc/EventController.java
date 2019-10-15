package com.spring.mvc.startmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    // ViewName 명시적 지정 1
    @GetMapping("/events1") // @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String getEvents1(ModelMap modelMap) { // Model은 인터페이스(model.addAttribute())이고 ModelMap은 구현 클래스(modelMap.addAttribute())로 같은 역할, 메소드 호출 시 생성

        // model.getClass() = modelMap.getClass(): org.springframework.validation.support.BindingAwareModelMap extends org.springframework.ui.ExtendedModelMap(Map)
        modelMap.addAttribute("events", eventService.getEvents()); // 변수 이름, 변수에 넣을 데이터

        return "eventList"; // View 명
    }

    // ViewName 명시적 지정 2
    @GetMapping("/events2")
    public ModelAndView getEvents2() {

        // 생성자 이용
        ModelAndView mav = new ModelAndView("eventList");

        // Setter 이용
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("eventList");
//        mav.setViewName("redirect:eventList"); // Redirect 시

        mav.addObject("events", eventService.getEvents());

        return mav; // Model과 View 모두 반환
    }

    // ViewName 비명시적 지정
    @GetMapping("/events3")
    public Model getEvents3(Model model) { // DefaultRequestToViewNameTranslator를 통해 ViewName을 생성함

        model.addAttribute("events", eventService.getEvents()); // 변수 이름, 변수에 넣을 데이터

        return model; // Map 반환도 가능
    }
}
