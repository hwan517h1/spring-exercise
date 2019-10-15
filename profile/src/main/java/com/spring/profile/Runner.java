package com.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Repository repository;
    // Profile이 default이면 에러 발생하므로 test로 바꿀 것
    // Edit Configurations에서 Active Profiles에 test나, VM options에 -Dspring.profiles.active="test"를 기입하면 됨

    @Autowired
    MessageSource messageSource; // MessageSource

    @Autowired
    ApplicationEventPublisher applicationEventPublisher; // EventPublisher

    @Autowired
    ResourceLoader resourceLoader; // ResourceLoader

    // Properties
    @Value("${app.date}")
    String date;
    @Value("${app.description}")
    String description;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = applicationContext.getEnvironment();

        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(Arrays.toString(environment.getActiveProfiles()));

        System.out.println(environment.getProperty("app.date")); // VM option
        System.out.println(environment.getProperty("app.description")); // test.properties

        System.out.println(date);
        System.out.println(description);

        // MessageSource
        System.out.println(messageSource.getMessage("greeting", new String[]{"kyunghwan"}, Locale.getDefault()));
        System.out.println(messageSource.getMessage("greeting", new String[]{"kyunghwan"}, Locale.KOREA  ));

        // EventPublisher
        applicationEventPublisher.publishEvent(new Event(this, 100));

        // ResourceLoader
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println(resource.exists());
        System.out.println(resource.getDescription());
    }
}
