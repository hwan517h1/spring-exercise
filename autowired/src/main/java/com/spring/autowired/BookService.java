package com.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    // 생성자를 이용한 의존성 주입
//    BookRepository bookRepository;
//
//    @Autowired(required = true)
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    // Setter를 이용한 의존성 주입
    BookRepository bookRepository;

    @Autowired @Primary
//    required가 true이고, @Repository가 없으면 의존성 주입을 하지 못해 에러가 발생함
//    required가 false이고, @Repository가 없으면 bookRepository 없이 BookService의 인스턴스는 생성됨
//    @Primary는 여러 개 중 하나를 선택할 때
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 필드만 이용한 의존성 주입
//    @Autowired
//    BookRepository bookRepository;
}
