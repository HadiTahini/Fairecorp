package com.example.smartbuilding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SmartBuildingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartBuildingApplication.class, args);
    }

}
