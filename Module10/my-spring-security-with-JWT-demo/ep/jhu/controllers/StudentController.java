package ep.jhu.controllers;

import ep.jhu.entity.Student;
import ep.jhu.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // Marks the class a rest controller
@RequestMapping("/api/user") // Requests made to /api/auth/anything will be handles by this class
public class StudentController {

    // Injecting Dependencies
    @Autowired private StudentRepo studentRepo;

    // Defining the function to handle the GET route to fetch student information of the authenticated student
    @GetMapping("/info")
    public Student getStudentDetails(){
        // Retrieve email from the Security Context
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Fetch and return student details
        return studentRepo.findByEmail(email).get();
    }


}
