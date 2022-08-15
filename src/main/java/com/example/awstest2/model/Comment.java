package com.example.awstest2.model;

import java.sql.Timestamp;

public class Comment
{
    private int pno;
    private int cno;
    private String cid;
    private String cment;
    private Timestamp cdate;
    private int cccnt;

    public Comment(int pno, int cno, String cid, String cment, Timestamp cdate, int cccnt) {
        this.pno = pno;
        this.cno = cno;
        this.cid = cid;
        this.cment = cment;
        this.cdate = cdate;
        this.cccnt = cccnt;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCment() {
        return cment;
    }

    public void setCment(String cment) {
        this.cment = cment;
    }

    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    public int getCccnt() {
        return cccnt;
    }

    public void setCccnt(int cccnt) {
        this.cccnt = cccnt;
    }
}
