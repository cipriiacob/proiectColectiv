package com.example.model;

/**
 * Created by Cipri on 08-Nov-16.
 */
public class User {

    private int id;

    private String username;

    private String password;

    public int getId() {

        return id;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public User(int id, String username, String password) {


        this.id = id;
        this.username = username;
        this.password = password;
    }
}
