package com.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//public class EventValidator implements Validator {
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Event.class.equals(aClass );
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "empty", "Empty id is not allowed.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty", "Empty title is not allowed.");
//    }
//}
