package com.mycompany.httpapimydemo.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.httpapimydemo.model.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@RestController
public class DemoRestController {

// @RestController is a specialized version of the controller. 
// It includes the @Controller and @ResponseBody annotations, 
// and as a result, simplifies the controller implementation:==> wraps @Controller
// It also wraps @Component
//

@GetMapping("/demo1")
public String do1() {
    return " --- I am do1 method --- ";
}

@GetMapping("/demo2")
public String do2() {
    return "--- I am do2 method --- ";
}

@GetMapping("/demo3")
public String do3() {
    return "--- I am do3 method --- ";
}

@GetMapping("/message")
public MyOutputResource getMessage() {
    return new MyOutputResource("Hello from getMessage, 605.784 class!");
}

@GetMapping(value="/messageMedia",
            produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Student>>  getMessageMedia() {
    return new ResponseEntity<List<Student>>(students(), HttpStatus.OK);
}

private List<Student> students() {
    List<Student> students = Arrays.asList(
            new Student("John", "ComputerScience"),
            new Student("Michael", "Information Systems Engineering"), 
            new Student("Harris", "Artificial Intelligence"),
            new Student("Paul", "CyberSecurity"), 
            new Student("Raymond", "DataScience"));
    return students;
}

}