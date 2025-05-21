package com.mycompany.demo.controllers;

import com.mycompany.demo.dtos.CreateStudentDto;
import com.mycompany.demo.dtos.CreateCourseDto;
import com.mycompany.demo.models.Student;
import com.mycompany.demo.models.Course;
import com.mycompany.demo.repositories.StudentRepository;
import com.mycompany.demo.repositories.CourseRepository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
  CourseRepository courseRepository;
  StudentRepository studentRepository;

  public SchoolController(CourseRepository courseRepository, StudentRepository studentRepository) {
    this.courseRepository  = courseRepository;
    this.studentRepository = studentRepository;
  }

  @PostMapping("/courses")
  public ResponseEntity<Course> createCourse(@RequestBody CreateCourseDto createCourseDto) {
    Course courseCreated = courseRepository.save(createCourseDto.toCourse());

    return new ResponseEntity<>(courseCreated, HttpStatus.CREATED);
  }

  @PostMapping("/students")
  public ResponseEntity<Student> createStudent(@RequestBody CreateStudentDto createStudentDto) {
    Student studentCreated = studentRepository.save(createStudentDto.toStudent());

    return new ResponseEntity<>(studentCreated, HttpStatus.CREATED);
  }

  @PutMapping("/courses/{id}")
  public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody CreateCourseDto createCourseDto) {
    Optional<Course> optionalCourse = courseRepository.findById(id);

    if (optionalCourse.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    }

    Course courseToUpdate = optionalCourse.get()
          .setCourseNumber(createCourseDto.getCourseNumber())
          .setCourseName(createCourseDto.getCourseName());

    Course courseUpdated =  courseRepository.save(courseToUpdate);

    return new ResponseEntity<>(courseUpdated, HttpStatus.OK);
  }

  @DeleteMapping("/courses/{id}")
  public ResponseEntity<Void> deleteCourse(@PathVariable String id, @RequestBody CreateCourseDto createCourseDto) {
    courseRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping("/students/bulk")
  public ResponseEntity<List<Student>> createStudents(@RequestBody List<CreateStudentDto> createStudentDtoList) {
    List<Student> students = createStudentDtoList
        .stream()
        .map(CreateStudentDto::toStudent)
        .collect(Collectors.toList());

    List<Student> studentsCreated = studentRepository.saveAll(students);

    return new ResponseEntity<>(studentsCreated, HttpStatus.CREATED);
  }

  @PostMapping("/courses/{id}/students")
  public ResponseEntity<Course> addStudentsToCourse(@PathVariable String id, @RequestBody List<String> studentIds) {
    Optional<Course> optionalCourse = courseRepository.findById(id);

    if (optionalCourse.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.OK);
    }

    Course courseToUpdate = optionalCourse.get();

    Set<Student> studentsToAdd = studentIds.stream()
        .map(studentId -> studentRepository.findById(studentId))
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toSet());

    courseToUpdate.setStudents(studentsToAdd);

    Course courseUpdated =  courseRepository.save(courseToUpdate);

    return new ResponseEntity<>(courseUpdated, HttpStatus.OK);
  }

  @GetMapping("/courses")
  public ResponseEntity<List<Course>> allCourses() {
    List<Course> courses = courseRepository.findAll(Sort.by(Direction.DESC, "courseName"));
    return new ResponseEntity<>(courses, HttpStatus.OK);
  }

  
  @GetMapping("/students")
  public ResponseEntity<List<Student>> allStudents() {
    List<Order> orders = new ArrayList<>(){{
      add(Order.by("name").with(Direction.DESC));
    }};
    List<Student> students = studentRepository.findAll(Sort.by(orders));
    //  List<Student> students = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  

  @GetMapping("/courses/{id}")
  public ResponseEntity<Course> oneCourse(@PathVariable String id) {
    Optional<Course> courseOptional = courseRepository.findById(id);

    return courseOptional
        .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Student> oneStudent(@PathVariable String id) {
    Optional<Student> studentOptional = studentRepository.findById(id);

    return studentOptional
        .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
        .orElseGet(() -> ResponseEntity.notFound().build());

  }

}