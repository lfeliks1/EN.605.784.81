package com.mycompany.demo.dtos;

import com.mycompany.demo.models.StudentLevel;
import com.mycompany.demo.models.Student;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentDto {
  private String name;

  private Date birthDate;

  private StudentLevel level;

  private boolean isAvailable;

  public Student toStudent() {
    return new Student().setName(name).setBirthDate(birthDate).setLevel(level).setAvailable(isAvailable);
  }
}