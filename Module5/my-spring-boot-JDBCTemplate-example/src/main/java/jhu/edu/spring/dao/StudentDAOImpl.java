package jhu.edu.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jhu.edu.model.Student;
import jhu.edu.model.StudentMapper;

@Component
public class StudentDAOImpl implements StudentDAO {

	JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_STUDENT = "select * from student where id = ?";
	private final String SQL_DELETE_STUDENT = "delete from student where id = ?";
	private final String SQL_UPDATE_STUDENT = "update student set first_name = ?, last_name = ?, email  = ? where id = ?";
	private final String SQL_GET_ALL = "select * from student";
	private final String SQL_INSERT_STUDENT = "insert into student (id, first_name, last_name, email) values(?,?,?,?)";

	@Autowired
	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Student getStudentById(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_STUDENT, new Object[] { id }, new StudentMapper());
	}

	public List<Student> getAllStudents() {
		return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper());
	}

	public boolean deleteStudent(Student student) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT, student.getId()) > 0;
	}

	public boolean updateStudent(Student student) {
		return jdbcTemplate.update(SQL_UPDATE_STUDENT, student.getFirstName(), student.getLastName(), student.getEmail(),
				student.getId()) > 0;
	}

	public boolean createStudent(Student student) {
		return jdbcTemplate.update(SQL_INSERT_STUDENT, student.getId(), student.getFirstName(), student.getLastName(),
				student.getEmail()) > 0;
	}
}
