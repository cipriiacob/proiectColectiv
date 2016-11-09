package com.example.controller;


import com.example.model.User;
import com.example.repository.UserDaoJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Cipri on 06-Nov-16.
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserDaoJdbc userDaoJdbc;

    @RequestMapping("/list")
    public ResponseEntity<List<User>> listUsers() {

        try {

            List<User> users = userDaoJdbc.getUsers();

            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
//            e.printStackTrace();
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
