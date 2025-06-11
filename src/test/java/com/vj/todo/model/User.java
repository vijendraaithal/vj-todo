package com.vj.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @JsonIgnore
    private String accessToken;

    public User() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        if (firstName.length() < 3) firstName += "aa";
        lastName = faker.name().lastName();
        if (lastName.length() < 3) lastName += "oo";
        email = firstName + "." + lastName + faker.number().numberBetween(100, 500) + "@email.com";
        password = "Test123!";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
