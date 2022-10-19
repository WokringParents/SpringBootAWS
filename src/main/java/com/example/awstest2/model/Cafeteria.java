package com.example.awstest2.model;

import java.sql.Timestamp;

public class Cafeteria {

    private int tid;
    private String cdate;
    private int ctype;
    private String content;
    private String image;

    public Cafeteria(int tid, String cdate, int ctype, String content, String image) {
        this.tid = tid;
        this.cdate = cdate;
        this.ctype = ctype;
        this.content = content;
        this.image = image;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public int getCtype() {
        return ctype;
    }

    public void setCtype(int ctype) {
        this.ctype = ctype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
