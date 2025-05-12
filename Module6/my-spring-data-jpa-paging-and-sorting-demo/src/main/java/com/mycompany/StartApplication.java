package com.mycompany;

import com.mycompany.course.Course;
import com.mycompany.course.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StartApplication {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Autowired
    CourseRepository courseRepository;

    @Bean
    public CommandLineRunner startup() {

        return args -> {

            Course c1 = new Course("605.784",
                                    "Enterprise Computing with Java",
                                    "online");
                    
            Course c2 = new Course("605.789",
                                    "Service API Design and Development",
                                    "online");  
    
            Course c3 = new Course("605.649",
                                    "Introduction to Machine Learning",
                                    "virtual live");                
            
            Course c4 = new Course("605.788",
                                    "Big Data Processing Using Hadoop",
                                    "in-person");                                              
                                
            Course c5 = new Course("685.648",
                                    "Data Science",
                                    "virtual live");
                    
            Course c6 = new Course("605.746",
                                    "Advanced Machine Learning",
                                    "online");               
            
            Course c7 = new Course("605.621",
                                    "Foundations of Algorithms",
                                    "online");                
                                                      
            Course c8 = new Course("605.646",
                                    "Natural Language Processing",
                                    "virtual live");
                    
            Course c9 = new Course("625.741",
                                    "Game Theory",
                                    "online");

            Course c10 = new Course("605.741",
                                    "Large-Scale Database Systems",
                                    "virtual live");

            Course c11 = new Course("605.741",
                                    "Large-Scale Database Systems",
                                    "in-person");

            Course c12 = new Course("605.741",
                                    "Large-Scale Database Systems",
                                    "online");

            Course c13 = new Course("605.647",
                                    "Neural Networks",
                                    "virtual live");

            Course c14 = new Course("605.647",
                                    "Neural Networks",
                                    "online");

            Course c15 = new Course("605.647",
                                    "Neural Networks",
                                    "in-person");

            courseRepository.saveAll(List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15));

        };

    }

}