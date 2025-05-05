package app.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {

    private final Student student;
    private final Faculty faculty;

    @Autowired
    public School(Student student, Faculty faculty) {
        this.student = student;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return String.format("Student: %s Faculty: %s", student, faculty);
    }
}