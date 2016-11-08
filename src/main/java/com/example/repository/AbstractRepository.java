package com.example.repository;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class AbstractRepository {

    public DriverManagerDataSource dataSource;

    public AbstractRepository(){
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        this.dataSource.setUrl("jdbc:mysql://localhost:3306/colectiv");
        this.dataSource.setUsername("root");
        this.dataSource.setPassword("1234");
    }
}
