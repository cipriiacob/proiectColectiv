package com.example.controller;


import com.example.model.User;
import com.example.repository.UserDaoJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Cipri on 06-Nov-16.
 */
@Controller
@RequestMapping("/users")
public class ControllerExample {


    @Autowired
    UserDaoJdbc userDaoJdbc;

    @RequestMapping("/get")
    public
    @ResponseBody
    List<User> asd() {

        List<User> users = userDaoJdbc.getUsers();

        return users;

    }
}
