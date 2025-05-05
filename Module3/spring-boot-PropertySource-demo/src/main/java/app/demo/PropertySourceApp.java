package app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertySourceApp {
    public static final void main(String...args) {
        SpringApplication.run(PropertySourceApp.class, args).close();
    }        
}      

