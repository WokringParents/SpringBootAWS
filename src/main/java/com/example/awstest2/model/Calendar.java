package com.example.awstest2.model;

import java.sql.Timestamp;

public class Calendar {

    private int couplenum;

    private String cdate;

    private String startTime;


    private String endTime;

    private String ccontent;

    private String csex;


    public Calendar(int couplenum, String cdate, String startTime, String endTime, String ccontent, String csex) {
        this.couplenum = couplenum;
        this.cdate = cdate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ccontent = ccontent;
        this.csex = csex;
    }


    public int getCouplenum() {
        return couplenum;
    }

    public void setCouplenum(int couplenum) {
        this.couplenum = couplenum;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

}
