package com.example;

import com.example.repository.UserDaoJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerProiectColectivApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServerProiectColectivApplication.class, args);
        UserDaoJdbc userDaoJdbc = new UserDaoJdbc();
        userDaoJdbc.doSomething();
    }
}
