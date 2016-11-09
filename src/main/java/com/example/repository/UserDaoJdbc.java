package com.example.repository;

import com.example.exceptions.DuplicatedUserException;
import com.example.exceptions.UserException;
import com.example.exceptions.UserNotFoundException;
import com.example.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoJdbc extends AbstractRepository {

    private JdbcTemplate jdbcTemplate;

    public UserDaoJdbc() {

        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getUsers() {

        String sql = "SELECT * FROM users";

        List<User> users = jdbcTemplate.query(sql, getUserRowMapper());

        return users;

    }

    public void newUser(int idRole, String username, String password) {
        //TODO: make this method to return the id of the newly added user

        String sql = "INSERT INTO users (id_role, username, password ) values (?, ?, ?)";
        try {

            jdbcTemplate.update(sql, idRole, username, password);
        } catch (DuplicateKeyException e) {

            throw new DuplicatedUserException("User with username '" + username + "' already exists", e);
        } catch (DataAccessException e) {

            throw new UserException("Error when trying to insert new user with username '" + username + "'", e);
        }
    }

    public User getUser(String username) {

        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            //TODO: improve this
            List<User> users = jdbcTemplate.query(sql, getUserRowMapper(), username);

            if (users.size() != 1) {
                throw new UserNotFoundException("User with username '" + username + "' not found");
            }
            return users.get(0);
        } catch (EmptyResultDataAccessException e) {

            throw new UserNotFoundException("User with username '" + username + "' not found", e);
        } catch (DataAccessException e) {

            throw new UserException("Error when trying to retrieve user with username '" + username + "'", e);
        }
    }

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
