package com.example.controller;

import com.example.repository.UserDaoJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cipri on 09-Nov-16.
 */
@Controller
@RequestMapping(value = "/initialize")
public class Initializer {

    @Autowired
    UserDaoJdbc userDaoJdbc;


    @RequestMapping(value = "/users")
    public void users() {

        userDaoJdbc.newUser(1, "username", "password");
    }

    @RequestMapping(value = "/all")
    public void all() {

        users();

    }

}
