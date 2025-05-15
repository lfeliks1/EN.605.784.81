package com.mycompany.httpapimydemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/modelDemo")
    public String doIt (Model model ) {
       model.addAttribute ("courseNumber", "605.784.81");
       model.addAttribute ("courseTitle", "Enterprise Computing with Java");
       return "homePage";  
    }

}