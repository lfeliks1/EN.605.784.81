package app.demo.bean;

public class Student {

    private final String name;
    private final int studId;

    public Student(String name, int studId) {
        this.name = name;
        this.studId = studId;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, studId);
    }
}


