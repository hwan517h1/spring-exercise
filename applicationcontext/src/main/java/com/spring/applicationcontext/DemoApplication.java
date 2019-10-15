package com.spring.applicationcontext;

// 방법 6: Spring Boot
//import org.springframework.boot.SpringApplication; // 방법 6
//import org.springframework.boot.autoconfigure.SpringBootApplication; // 방법 6
//
//@SpringBootApplication // 방법 6: Bean 설정 포함
//public class DemoApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args); // 방법 6
//    }
//}

// 방법 1: xml에서 직접 의존성 주입한 것 확인하기
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Arrays;
//
//public class DemoApplication {
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(beanDefinitionNames));
//        BookService bookService = (BookService) applicationContext.getBean("bookService");
//        System.out.println(bookService.bookRepository != null);
//    }
//}

// 방법 3: xml 대신 Java 설정 파일 이용하기, 방법 5
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService.bookRepository != null);
    }
}