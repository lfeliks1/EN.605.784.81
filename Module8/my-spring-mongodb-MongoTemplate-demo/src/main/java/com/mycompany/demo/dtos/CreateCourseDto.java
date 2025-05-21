package com.mycompany.demo.dtos;

import com.mycompany.demo.models.Course;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCourseDto {
  private String courseNumber;

  private String courseName;
 
  public Course toCourse() {
    return new Course().setCourseNumber(courseNumber).setCourseName(courseName);
  }
}
