package com.university;

/**
 * Created by Tharindu on 7/22/2017.
 */

public class Lecturer extends Person {

    private String lecturerId;
    private double salary;
    private String contractType;

    public Lecturer(String lecturerId, String name, String address) {
        super(name, address);
        this.lecturerId = lecturerId;
        setLecturerId(lecturerId);
    }
    
    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

     public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

}

