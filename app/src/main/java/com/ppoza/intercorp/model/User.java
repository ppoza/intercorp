package com.ppoza.intercorp.model;

public class User {

    public String name;
    public String lastName;
    public int age;
    public long birthDate;

    public User() {
    }

    public User(String name, String lastName, int age, long birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }
}
