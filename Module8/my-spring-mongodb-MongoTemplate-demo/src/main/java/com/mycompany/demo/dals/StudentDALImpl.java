package com.mycompany.demo.dals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.demo.models.Student;

@Repository
public class StudentDALImpl implements StudentDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Student> getAllStudents() {
		return mongoTemplate.findAll(Student.class);
	}

	@Override
	public Student getStudentByName(String studentName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(studentName));
		return mongoTemplate.findOne(query, Student.class);

	}

	/* 
	@Override
	public Student addNewStudent(Student student) {
		mongoTemplate.save(student);
		return student;
	}
*/

}


	/* 
	@Override
	public Student setStudentLevel(String studentName, String studentLevel) {

	// Update
    mongoTemplate.updateFirst(query(where("name").is("studentName")), update("level", "studentLevel"), Student.class);
    Student s = mongoTemplate.findOne(query(where("name").is("studentName")), Student.class);
	// to print updated Student document
	}
*/

/* 
	@Override
	public Object getAllStudentSettings(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings() : "User not found.";
	}

	@Override
	public String getUserSetting(String userId, String key) {
		Query query = new Query();
		query.fields().include("userSettings");
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User user = mongoTemplate.findOne(query, User.class);
		return user != null ? user.getUserSettings().get(key) : "Not found.";
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if (user != null) {
			user.getUserSettings().put(key, value);
			mongoTemplate.save(user);
			return "Key added.";
		} else {
			return "User not found.";
		}
	}
   */
