package com.spring;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;


public class MyTasklet2 implements Tasklet {

    private DataSource dataSource;
    private String sql = "SELECT * FROM employees WHERE emp_no < 10101;";

    public MyTasklet2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTasklet2");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        List items = jdbcTemplate.query(this.sql, new MyRowMapper());

        System.out.println("작업 수: " + items.size());
        for (Object object : items) {
            Employee employee = (Employee) object;
            System.out.print(employee.getFirst_name() + " ");
            System.out.println(employee.getLast_name());
        }
        System.out.println("작업 완료");

        return RepeatStatus.FINISHED;
    }
}
