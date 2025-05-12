package com.mycompany.model;
import jakarta.persistence.*;

@Entity
@Table(name="REGISTERED_STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Student_Name")
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student {" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}