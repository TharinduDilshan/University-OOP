/**
 * Created by Tharindu on 7/22/2017.
 */

package com.university;

public abstract class Person {

    private String name;
    private String address;

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {

        return address;
    }
}
