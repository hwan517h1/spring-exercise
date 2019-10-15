package com.spring.applicationcontext;

// 방법 2: xml 참고하여 scan하기, 방법 5
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}

// 방법 3
//public class BookService {
//    BookRepository bookRepository;
//
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//}

// 방법 4
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class BookService {
//    @Autowired
//    BookRepository bookRepository;
//
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//}