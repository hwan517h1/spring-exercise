package com.spring.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Event {

    // EventValidator 이용
//    Integer id;
//    String  title;
//
//    public Integer getId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }

    // Validator 이용
    @NotNull
    Integer id;

    @Min(0)
    Integer limit;

    @Email
    String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
