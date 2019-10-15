package com.spring.proxyaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyAopApplication {

    public static void main(String[] args) {
        // Spring Boot 없이 구동하기
        SpringApplication springApplication = new SpringApplication(ProxyAopApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

//        SpringApplication.run(ProxyAopApplication.class, args);
    }
}
