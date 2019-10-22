package com.spring;

import org.apache.ibatis.session.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MyTasklet implements Tasklet {

    // 방법 2
    @Autowired
    private MyRepository myRepository;

    // 방법 3
//    @Autowired
//    private MyImplementation myImplementation;

    // 방법 4
    @Autowired
    private MyInterface myInterface;

    // 방법 1
//    private DataSource dataSource;
//    private String sql;
//
//    public DataSource getDataSource() {
//        return dataSource;
//    }
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    public String getSql() {
//        return sql;
//    }
//    public void setSql(String sql) {
//        this.sql = sql;
//    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("작업 시작");

        // 방법 1
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
//        List items = jdbcTemplate.query(this.getSql(), new MyRowMapper());

        MyParameter myParameter = new MyParameter();
        myParameter.setEmp_no(10101);

        // 방법 2
//        List<Employee> items = this.myRepository.search();

        // 방법 3
//        List<Employee> items = this.myImplementation.search(myParameter);

        // 방법 4
        List<Employee> items = this.myInterface.search(myParameter);

        for (Object object : items) {
            Employee employee = (Employee) object;
            System.out.print(employee.getFirst_name() + " ");
            System.out.println(employee.getLast_name());
        }

        System.out.println("작업 수: " + items.size());
        System.out.println("작업 완료");

        return RepeatStatus.FINISHED;
    }
}
