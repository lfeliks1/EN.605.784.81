package com.mycompany.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "courseTitle") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {
                Page <Course> result = courseService.findAll(pageNo, pageSize, sortBy, sortDirection);
                return result.getContent();
            }

}

