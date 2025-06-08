package jhu.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringSecurityForARestApiApplication {
    
    public static void main(String[] args) {        

        System.out.println("+++++++++++++++SpringSecurityForARestApiApplication++++++++++++++++++++++++");

        SpringApplication.run(SpringSecurityForARestApiApplication.class, args);
    }
}