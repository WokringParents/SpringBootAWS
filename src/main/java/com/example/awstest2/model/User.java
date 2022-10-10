package com.example.awstest2.model;

public class User {
    private String id;
    private String pw;
    private String email;
    private String sex;

    private String token;

    private String name;

    private String pnumber;

    private String city;

    private String village;

    public User(String id, String pw, String email, String sex, String token, String name, String pnumber, String city, String village) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.sex = sex;
        this.token = token;
        this.name = name;
        this.pnumber = pnumber;
        this.city = city;
        this.village = village;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}