package com.spring;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MyItemWriter implements ItemWriter<Employee> {

    @Override
    public void write(List<? extends Employee> items) throws Exception {

        for (Employee employee : items) {
            System.out.print(employee.getFirst_name() + " ");
            System.out.println(employee.getLast_name());
        }
    }
}
