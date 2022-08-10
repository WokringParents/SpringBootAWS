package com.example.awstest2.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;

public class Child {
    private String name;
    private String sex;
    private Timestamp birth;
    private String center;
    private int couplenum;

    public Child(String name, String sex, Timestamp birth, String center, int couplenum) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.center = center;
        this.couplenum = couplenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public int getCouplenum() {
        return couplenum;
    }

    public void setCouplenum(int couplenum) {
        this.couplenum = couplenum;
    }
}
