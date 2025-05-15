package com.mycompany.app;

public class Student {
    private int id;
    private String name;
    private String emailAddr;

    public Student() {
    }

    public Student(int id, String name, String emailAddress) {
        super();
        this.id = id;
        this.name = name;
        this.emailAddr = emailAddress;
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

    public String getemailAddr() {
        return emailAddr;
    }

    public void setemailAddr(String emailAddress) {
        this.emailAddr = emailAddress;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, emailAddr=%s]", 
                              id, name, emailAddr);
    }

}