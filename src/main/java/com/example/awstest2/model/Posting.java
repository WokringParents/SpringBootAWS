package com.example.awstest2.model;

import java.sql.Timestamp;

public class Posting {
    private int pno;
    private String pid;
    private String village;
    private String goback;
    private Timestamp pdate;
    private String content;
    private int hcnt;
    private int ccnt;

    public Posting(int pno, String pid, String village, String goback, Timestamp pdate, String content, int hcnt, int ccnt) {

        this.pno = pno;
        this.pid = pid;
        this.village = village;
        this.goback = goback;
        this.pdate = pdate;
        this.content = content;
        this.hcnt = hcnt;
        this.ccnt = ccnt;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getGoback() {
        return goback;
    }

    public void setGoback(String goback) {
        this.goback = goback;
    }

    public Timestamp getPdate() {
        return pdate;
    }

    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHcnt() {
        return hcnt;
    }

    public void setHcnt(int hcnt) {
        this.hcnt = hcnt;
    }

    public int getCcnt() {
        return ccnt;
    }

    public void setCcnt(int ccnt) {
        this.ccnt = ccnt;
    }
}
