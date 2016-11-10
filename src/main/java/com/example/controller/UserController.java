package com.example.controller;


import com.example.exceptions.UserNotFoundException;
import com.example.model.LoginCredentials;
import com.example.model.User;
import com.example.repository.UserDaoJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Cipri on 06-Nov-16.
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserDaoJdbc userDaoJdbc;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity login(@RequestBody @Valid LoginCredentials loginCredentials) {

        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();

        try {
            userDaoJdbc.getUserIdByCredentials(username, password);
        } catch (UserNotFoundException e) {
            System.out.println("\nlogin failed\n");
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        System.out.println("\nlogin with success\n");
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping("/list")
    public ResponseEntity<List<User>> listUsers() {

        try {

            List<User> users = userDaoJdbc.getUsers();

            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/get")
    public ResponseEntity<User> getUser() {

        try {

            User user = userDaoJdbc.getUser("awdwad");

            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
//            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
