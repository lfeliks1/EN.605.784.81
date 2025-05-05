package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration; 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@Configuration 
@EnableAutoConfiguration 
@ComponentScan

public class DemoApplication {

    public static void main(String[] args) {
        
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

        System.out.println("Hello, 605.784.81 class!");

        System.out.println("------------------------------------------------------------------------");
        System.out.println( "# beans: " + ctx.getBeanDefinitionCount());
        System.out.println("------------------------------------------------------------------------");      
        //creating of array of bean names
        String[] beanNames = ctx.getBeanDefinitionNames();
        //sorting array of bean names
        Arrays.sort(beanNames);      
        //looping thru array of the bean names 
        for (String beanName : beanNames) {
            System.out.println("***" + beanName + " : " + ctx.getBean(beanName).getClass().toString() + "\n");        
        }
    }
}

