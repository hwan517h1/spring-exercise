package com.spring.databinding;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Converter
//        registry.addConverter(new EventConverter.EventToStringConverter());

        // Formatter
        registry.addFormatter(new EventFormatter());
    }
}
