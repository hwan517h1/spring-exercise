package com.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class ServletConfiguration implements WebMvcConfigurer {

    // 1. 기본 전략 대신 Custom ViewResolver을 Bean으로 등록함(기본 전략인 InternalResourceViewResolver에 새롭게 조건을 추가한 경우)
//    @Bean
//    public ViewResolver viewResolver()  {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/");
//        viewResolver.setSuffix(".jsp");
//
//        return viewResolver;
//    }

    // 2. Bean 등록 대신 WebMvcConfigurer를 구현하여 @EnableWebMvc이 제공하는 빈을 수정할 수 있음
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }
}
