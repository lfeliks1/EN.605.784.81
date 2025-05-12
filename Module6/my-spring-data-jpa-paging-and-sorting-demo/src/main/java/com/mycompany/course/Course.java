package com.mycompany.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseNumber;
    private String courseTitle;
    private String modality;

    // for JPA only, no use
    public Course() {
    }

    public Course(String number, String title, String mode ) {
        courseNumber = number;
        courseTitle  = title;
        modality     = mode;
    }

    public Course(Long id, String number, String title, String mode ) {
        this.id = id;
        courseNumber = number;
        courseTitle  = title;
        modality     = mode;
    }

    @Override
    public String toString() {
        return "Course {" +
                "id = " + id +
                ", course number = " + courseNumber +
                ", course title = " + courseTitle +
                ", course modality = " + modality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String title) {
        courseTitle = title;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String number) {
        courseNumber = number;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String mode) {
        modality = mode;
    }

}