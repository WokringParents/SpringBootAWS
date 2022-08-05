package com.example.awstest2.model;

public class User {
    private String id;
    private String pw;
    private String email;
    private String sex;

    private String token;

    public User(String id, String pw, String email, String sex) {
        super();
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}