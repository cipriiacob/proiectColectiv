package com.example.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Cipri on 10-Nov-16.
 */

public class LoginCredentials {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public LoginCredentials() {

    }

    public LoginCredentials(String username, String password) {


        this.username = username;
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }
}
