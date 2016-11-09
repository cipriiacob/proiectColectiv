package com.example.repository;

import com.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoJdbc {

    private JdbcTemplate jdbcTemplate;

    public UserDaoJdbc() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/proiect_colectiv");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getUsers() {

        String sql = "SELECT * FROM user";

        List<User> users = jdbcTemplate.query(sql, getUserRowMapper());
        System.out.println(users.size());
        return users;

    }
//
//    private List<User> getUsersRowMapper() {
//
//        return this.jdbcTemplate.query("select * from user", new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int i) throws SQLException {
//
//                int id = rs.getInt("id");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//
//                return new User(id, username, password);
//
//            }
//        });
//    }

    RowMapper<User> getUserRowMapper() {

        return new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                return new User(id, username, password);

            }
        };
    }

}
