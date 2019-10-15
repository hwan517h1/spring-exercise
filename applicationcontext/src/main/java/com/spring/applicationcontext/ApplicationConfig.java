// application.xml 대신하는 Java 설정 파일
package com.spring.applicationcontext;

// 방법 3: Java로 의존성 주입하기
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Bean;
//
//@Configuration
//public class ApplicationConfig {
//    @Bean
//    public BookRepository bookRepository() {
//        return new BookRepository();
//    }
//
//    @Bean
//    public BookService bookService()  {
//        BookService bookService = new BookService();
//        bookService.setBookRepository(bookRepository());
//
//        return bookService;
//    }
//}

// 방법 4: 방법 3처럼 직접 의존성 주입하지 않고 BookService.java에서 bookRepository에 @Autowired를 붙임
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Bean;
//
//@Configuration
//public class ApplicationConfig {
//
//    @Bean
//    public BookRepository bookRepository() {
//        return new BookRepository();
//    }
//
//    @Bean
//    public BookService bookService()  {
//        return new BookService(); // 방법 4
//    }
//}

// 방법 5
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {}
