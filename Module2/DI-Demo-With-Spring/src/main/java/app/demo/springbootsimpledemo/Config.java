package app.demo.springbootsimpledemo;

import app.demo.bean.Student;
import app.demo.bean.Faculty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("app.demo.bean")
public class Config {

    @Bean
    public Student student() {
        return new Student("John_Student", 123);
    }

    @Bean
    public Faculty faculty() {
        return new Faculty("Professor_Doe");
    }
}