package com.university;

public class Student extends Person {
    private int studentId;


    public Student(int studentId, String name, String address) {
        super(name, address);
        this.setStudentId(studentId);

        setStudentId(studentId);
    }


    public int getStudentId() {
        return studentId;
    }



    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
