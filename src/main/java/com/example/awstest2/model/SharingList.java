package com.example.awstest2.model;

import java.sql.Timestamp;

public class SharingList {

    private int couplenum;
    private Timestamp sdate;
    private String content;
    private boolean mdo;
    private boolean fdo;
    private int dayOfWeek;


    public SharingList(int couplenum, Timestamp sdate, String content, boolean mdo, boolean fdo, int dayOfWeek) {
        this.couplenum = couplenum;
        this.sdate = sdate;
        this.content = content;
        this.mdo = mdo;
        this.fdo = fdo;
        this.dayOfWeek = dayOfWeek;
    }

    public int getCouplenum() {
        return couplenum;
    }

    public void setCouplenum(int couplenum) {
        this.couplenum = couplenum;
    }

    public Timestamp getSdate() {
        return sdate;
    }

    public void setSdate(Timestamp sdate) {
        this.sdate = sdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMdo() {
        return mdo;
    }

    public void setMdo(boolean mdo) {
        this.mdo = mdo;
    }

    public boolean isFdo() {
        return fdo;
    }

    public void setFdo(boolean fdo) {
        this.fdo = fdo;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
