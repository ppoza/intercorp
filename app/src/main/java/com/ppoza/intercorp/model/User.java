package com.ppoza.intercorp.model;

public class User {

    public String name;
    public String lastName;
    public int age;
    public String birthDate;

    public User() {
    }

    public User(String name, String lastName, int age, String birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }
}
