package com.spring;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
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
@Import(value = {DataSourceConfigurer.class})
public class MyBatchConfigurer implements BatchConfigurer {

    @Autowired
    DriverManagerDataSource dataSource;
    @Autowired
    DataSourceTransactionManager transactionManager;

    @Bean(name = "jobRepository")
    public JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactory = new JobRepositoryFactoryBean();
        jobRepositoryFactory.setDataSource(dataSource);
        jobRepositoryFactory.setTransactionManager(transactionManager);

        return jobRepositoryFactory.getObject();
    }

    @Bean(name = "jobLauncher")
    public JobLauncher createJobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(createJobRepository());

        return jobLauncher;
    }

    @Bean(name = "jobExplorer")
    public JobExplorer createJobExplorer() throws Exception {
        JobExplorerFactoryBean jobExplorerFactory = new JobExplorerFactoryBean();
        jobExplorerFactory.setDataSource(dataSource);
        jobExplorerFactory.afterPropertiesSet();

        return jobExplorerFactory.getObject();
    }

    public JobRepository getJobRepository() throws Exception {
        return this.createJobRepository();
    }

    public PlatformTransactionManager getTransactionManager() throws Exception {
        return this.transactionManager;
    }

    public JobLauncher getJobLauncher() throws Exception {
        return this.createJobLauncher();
    }

    public JobExplorer getJobExplorer() throws Exception {
        return createJobExplorer();
    }
}
