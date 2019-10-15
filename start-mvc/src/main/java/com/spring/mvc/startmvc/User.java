package com.spring.mvc.startmvc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private int num;
    private String email;

    @Override
    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                '}';

        String result = id + ", " + num + ", " + email;

        return result;
    }
}
