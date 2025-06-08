package jhu.rest.controller;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("app/authN")
public class AuthNController {     
    @GetMapping("/welcome")
    public String welcome()
    {
         return "Welcome to RESTful service with Spring Security Basic AuthN implementation";
    }
}