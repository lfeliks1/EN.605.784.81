package app.demo.springbootpropertydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertyApp {
    public static final void main(String...args) {
        SpringApplication.run(PropertyApp.class, args).close();
    }
}      

