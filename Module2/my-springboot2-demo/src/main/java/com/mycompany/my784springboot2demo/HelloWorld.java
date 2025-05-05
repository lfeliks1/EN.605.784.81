package com.mycompany.my784springboot2demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorld {

    @PostConstruct
    public void sayHello() {
        System.out.println("Hello 605.785 class, from SpringBoot 2 framework!");
    }
}