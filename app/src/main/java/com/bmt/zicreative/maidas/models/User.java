package com.bmt.zicreative.maidas.models;

public class User {
    public String firstName;
    public String lastName;
    public String phone;
    public String role;

    public User(String firstName, String lastName, String phone, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
