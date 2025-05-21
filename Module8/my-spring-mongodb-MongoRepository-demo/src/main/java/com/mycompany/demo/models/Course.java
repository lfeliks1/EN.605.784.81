package com.mycompany.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "courses")
@Accessors(chain = true)
@Data
public class Course extends GenericModel{

  @Indexed(unique = true)
  @Field
  private String courseNumber;
  private String courseName;
  @DBRef
  private Set<Student> students;
  
  public Course() {
    this.students = new HashSet<>();
  }

}