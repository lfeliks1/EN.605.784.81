package jhu.rest.controller;

import jhu.rest.jpa.Student;
import jhu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public Student getUserDetail(@PathVariable Long id){
        return studentService.findById(id);
    }
}
