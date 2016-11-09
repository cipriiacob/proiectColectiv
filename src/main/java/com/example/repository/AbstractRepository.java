package com.example.repository;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AbstractRepository {

    protected DriverManagerDataSource dataSource = new DriverManagerDataSource();

    public AbstractRepository() {

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/proiect_colectiv");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
    }
}
