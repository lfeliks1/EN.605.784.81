package com.mycompany.httpapimydemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class HomeController {

    @RequestMapping("/modelAndViewDemo")
    public ModelAndView doIt () {
       Map<String, String> model = new HashMap<>();
       model.put ("courseNumber", "605.784.81");
       model.put ("courseTitle", "Enterprise Computing with Java"); 
       ModelAndView modelAndView = new ModelAndView("homePage", model);
        return modelAndView; 
    }

    @RequestMapping("/JSONmodelAndViewDemo")
    public ModelAndView doItJSON () {
       ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView()); 
       modelAndView.addObject("courseNumber", "605.784.81"); 
       modelAndView.addObject("courseTitle", "Enterprise Computing with Java");
       return modelAndView; 
    }
}