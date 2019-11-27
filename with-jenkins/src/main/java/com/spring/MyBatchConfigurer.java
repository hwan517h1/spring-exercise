package com.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableBatchProcessing
@Import(value = {DataSourceConfigurer.class})
public class MyBatchConfigurer implements BatchConfigurer {

    @Autowired
    DriverManagerDataSource dataSource;
    @Autowired
    DataSourceTransactionManager transactionManager;

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactory = new JobRepositoryFactoryBean();
        jobRepositoryFactory.setDataSource(dataSource);
        jobRepositoryFactory.setTransactionManager(transactionManager);

        return jobRepositoryFactory.getObject();
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());

        return jobLauncher;
    }

    @Bean
    public JobExplorer jobExplorer() throws Exception {
        JobExplorerFactoryBean jobExplorerFactory = new JobExplorerFactoryBean();
        jobExplorerFactory.setDataSource(dataSource);
        jobExplorerFactory.afterPropertiesSet();

        return jobExplorerFactory.getObject();
    }

    public JobRepository getJobRepository() throws Exception {
        return this.jobRepository();
    }

    public PlatformTransactionManager getTransactionManager() throws Exception {
        return this.transactionManager;
    }

    public JobLauncher getJobLauncher() throws Exception {
        return this.jobLauncher();
    }

    public JobExplorer getJobExplorer() throws Exception {
        return jobExplorer();
    }

    @Bean(name = "MyStep1")
    public Step step1() {
        return this.stepBuilderFactory.get("Step1")
                .tasklet(new MyTasklet1())
                .build();
    }

    @Bean(name = "MyStep2")
    public Step step2() {
        return this.stepBuilderFactory.get("Step2")
                .tasklet(new MyTasklet2(dataSource))
                .build();
    }

    @Bean(name = "MyJob")
    public Job job() {
        return this.jobBuilderFactory.get("Job")
                .start(step1())
                .next(step2())
                .build();
    }
}
