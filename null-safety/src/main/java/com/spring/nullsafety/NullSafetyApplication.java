package com.spring.nullsafety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NullSafetyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NullSafetyApplication.class, args);
    }

    // Spring 5에 새롭게 생긴 기능으로 컴파일 타임에 NullPointException을 방지하는 것을 목표로 함
}
