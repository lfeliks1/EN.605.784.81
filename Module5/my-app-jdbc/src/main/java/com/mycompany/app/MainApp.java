package com.mycompany.app;

import com.mycompany.app.StudentConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);
        
        System.out.println(".................. Start of MainApp.................");

        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student = new Student();

        // find student by name
        student = studentDao.findByStudentName("Student1");
        System.out.println  ("Student Id: " + student.getId() +
                             "Name: " + student.getName() +
                             "Email: " + student.getemailAddr());

        // find student by id
        student = studentDao.findByStudentId(12);
        System.out.println  ("Student Id: " + student.getId() +
                             "Name: " + student.getName() +
                             "Email: " + student.getemailAddr());
        
        // insert new student
        Student student55 = new Student(55, "Student55_Name", "Student55_email@email.com");
        studentDao.insert(student55);
        
        
        // update student by id id
        Student student1 = new Student(55, "Student99_Name", "Student99_email@email.com");
        studentDao.update(student1);
        Student student2 = studentDao.findByStudentId(55);
        System.out.println ("Student Id: " + student2.getId() +
                            "Name: " + student2.getName() +
                            "Email: " + student2.getemailAddr());
        

        System.out.println("........... End of MainApp ..............");
        System.exit(0);
    }
}
