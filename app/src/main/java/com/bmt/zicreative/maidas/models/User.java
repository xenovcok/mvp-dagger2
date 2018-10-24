package com.bmt.zicreative.maidas.models;

public class User {
    public String username;
    public String password;
    public String email;
    public String role;
    public String name;

    public User(String username, String password, String email, String role, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
    }

    public User() {

    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
