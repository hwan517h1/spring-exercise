package com.spring;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRepository {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public List<Employee> search() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int offset = 0;
        int limit = 10;

        try {
//            return sqlSession.selectList("search"); // 100개
            return sqlSession.selectList("search", null, new RowBounds(offset, limit)); // 10개
        }
        finally {
            sqlSession.close();
        }
    }
}