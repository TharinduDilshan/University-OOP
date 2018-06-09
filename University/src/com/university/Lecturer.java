package com.university;

/**
 * Created by Tharindu on 7/22/2017.
 */

public class Lecturer extends Person {

    private String lecturerId;

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

}

