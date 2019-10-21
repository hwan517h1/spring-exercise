package com.spring;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// 방법 3
//@Component
//public class MyImplementation implements MyInterface {
//
//    @Autowired
//    SqlSession sqlSession;
//
//    public List<Employee> search() {
//        return sqlSession.getMapper(MyInterface.class).search();
//    }
//}
