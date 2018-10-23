package com.bmt.zicreative.maidas.models;

public class User {
    public String userName;
    public String password;
    public String email;
    public String role;

    public User(String userName, String password, String email, String role, String name) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
