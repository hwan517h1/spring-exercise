package com.spring.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    // EventValidator 이용
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Event event = new Event();
//        EventValidator eventValidator = new EventValidator();
//        Errors errors = new BeanPropertyBindingResult(event, "event");
//
//        eventValidator.validate(event, errors);
//
//        System.out.println(errors.hasErrors());
//        errors.getAllErrors().forEach(e -> {
//            System.out.println("[ERROR CODE]");
//            Arrays.stream(e.getCodes()).forEach(System.out::println);
//            System.out.println(e.getDefaultMessage());
//        });
//    }

    // Validator 이용
    @Autowired
    Validator validator; // defaultValidator, mvcValidator
    // IntelliJ가 명시적으로 파악하지 못하는 경우로 validator 대신 defaultValidator나 mvcValidator로 바꾸면 됨(바람직하지 않음)

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("A");
        Errors errors = new BeanPropertyBindingResult(event, "event");

        System.out.println(applicationContext.getBeanNamesForType(validator.getClass())[0]);
        System.out.println(validator.getClass());

        validator.validate(event, errors);

        System.out.println(errors.hasErrors());
        errors.getAllErrors().forEach(e -> {
            System.out.println("[ERROR CODE]");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }
}
