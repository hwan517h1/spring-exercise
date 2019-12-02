package com.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@EnableBatchProcessing
@Import(value = {MyBatchConfigurer.class})
public class MyJobConfigurer {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean(name = "MyStep1")
    public Step step1() {
        return this.stepBuilderFactory.get("Step1")
                .tasklet(new MyTasklet1())
                .build();
    }

    @Bean(name = "MyStep2")
    public Step step2(DriverManagerDataSource dataSource) {
        return this.stepBuilderFactory.get("Step2")
                .tasklet(new MyTasklet2(dataSource))
                .build();
    }

    @Bean(name = "MyJob")
    public Job job(@Qualifier("MyStep1") Step MyStep1, @Qualifier("MyStep2") Step MyStep2) {
        return this.jobBuilderFactory.get("Job")
                .start(MyStep1)
                .next(MyStep2)
                .build();
    }
}
