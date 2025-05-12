package com.mycompany.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List <Student> findAll() {
        return studentService.findAll(); 
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    // create a student
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    // update a Student
    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.save(student);
    }

    // delete a Student
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/find/name/{last_name}")
    public List<Student> findByLastName(@PathVariable String last_name) {
        return studentService.findByLastName(last_name);
    }

    @GetMapping("/find/more-credits/{credits}")
    public List<Student> findByMoreCredits (
            @PathVariable int credits) {
        return studentService.findByMoreCredits (credits);
    }

    @GetMapping("/count")
    public Long count () {
        return studentService.count ( );
    }
}

