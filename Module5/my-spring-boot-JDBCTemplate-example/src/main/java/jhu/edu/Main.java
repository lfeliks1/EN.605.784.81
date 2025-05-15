package jhu.edu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jhu.edu.model.Student;
import jhu.edu.spring.config.AppConfig;
import jhu.edu.spring.dao.StudentDAO;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		StudentDAO studentDAO = context.getBean(StudentDAO.class);

		System.out.println("\n\nList of students is:");

		for (Student s : studentDAO.getAllStudents()) {
			System.out.println(s);
		}

		System.out.println("\n\nGet student with ID 1");

		Student studentById = studentDAO.getStudentById(1L);
		System.out.println(studentById);

		System.out.println("\n\nCreating a student with ID 4 : ");
		Student student = new Student(4L, "Joe99Doe99@email.com", "John99", "Doe99");
		System.out.println(student);
		studentDAO.createStudent(student);
		System.out.println("\n\nList of students is:");

		for (Student s : studentDAO.getAllStudents()) {
			System.out.println(s);
		}

		System.out.println("\n\nDeleting student with ID 1");
		boolean bool = studentDAO.deleteStudent(studentById);
		System.out.println("\n\nResult of deleting student with ID 1 is " +  bool);

		Student student7 = new Student(7L,"","","");
		System.out.println("\n\nDeleting student with ID 7");
		boolean bool7 = studentDAO.deleteStudent(student7);
		System.out.println("\n\nResult of deleting student with ID 7 is " +  bool7);

		System.out.println("\n\nUpdate student with ID 4");

		Student sstudent = studentDAO.getStudentById(4L);
		sstudent.setLastName("CHANGED");
		studentDAO.updateStudent(sstudent);

		System.out.println("\n\nList of students is:");
		for (Student s : studentDAO.getAllStudents()) {
			System.out.println(s);
		}

		context.close();
	}
}
