package com.mycompany.httpapimydemo.model;
public class Student {
 
    private String name;
    private String program;

    public Student() {
    }

    public Student(String name, String program) {
        this.name = name;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student [name = " + name + ", program = " + program + "]";
    }
}