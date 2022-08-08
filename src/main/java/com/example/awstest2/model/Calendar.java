package com.example.awstest2.model;

import java.sql.Timestamp;

public class Calendar {
    private int couplenum;
    private Timestamp cdate;
    private String ctitle;
    private String ccontent;
    private String csex;


    public Calendar(int couplenum, Timestamp cdate, String ctitle, String ccontent, String csex) {
        this.couplenum = couplenum;
        this.cdate = cdate;
        this.ctitle = ctitle;
        this.ccontent = ccontent;
        this.csex = csex;
    }


    public int getCouplenum() {
        return couplenum;
    }

    public void setCouplenum(int couplenum) {
        this.couplenum = couplenum;
    }

    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
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
