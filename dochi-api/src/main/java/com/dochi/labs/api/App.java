package com.dochi.labs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.dochi.labs"})
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
