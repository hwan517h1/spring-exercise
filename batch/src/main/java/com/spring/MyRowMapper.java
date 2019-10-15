package com.spring;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Employee employee = new Employee();
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));

        return employee;
    }
}
