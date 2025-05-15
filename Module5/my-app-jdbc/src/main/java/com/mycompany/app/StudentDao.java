package com.mycompany.app;

public interface StudentDao {

    public void insert(Student student);
    public void update(Student student);
    public void delete(Student student);
    public Student findByStudentName(String studentName);
    public Student findByStudentId(int id);

}
