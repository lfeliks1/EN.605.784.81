package app.demo.springbootsimpledemo;

import app.demo.bean.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleDemoApp {

    public static void main(String[] args) {
        School jhu = getSchoolFromXml();

        System.out.println("\n" + jhu + "\n");

        jhu = getSchoolFromJavaConfig();

        System.out.println("\n" + jhu + "\n");
    }

    private static School getSchoolFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        return context.getBean(School.class);
    }

    private static School getSchoolFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("DIconstructor.xml");

        return context.getBean(School.class);
    }

}