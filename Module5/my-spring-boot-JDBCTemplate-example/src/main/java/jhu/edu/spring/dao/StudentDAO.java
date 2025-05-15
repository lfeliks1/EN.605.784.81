package jhu.edu.spring.dao;

import java.util.List;

import jhu.edu.model.Student;

public interface StudentDAO {
	Student getStudentById(Long id);

	List<Student> getAllStudents();

	boolean deleteStudent(Student student);

	boolean updateStudent(Student student);

	boolean createStudent(Student student);
}
