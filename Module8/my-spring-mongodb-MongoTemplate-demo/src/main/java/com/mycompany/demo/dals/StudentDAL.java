package com.mycompany.demo.dals;

import java.util.List;
import com.mycompany.demo.models.Student;

public interface StudentDAL {

	List<Student> getAllStudents();

	Student getStudentByName(String studentName);

}