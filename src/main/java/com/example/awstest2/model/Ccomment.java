package com.example.awstest2.model;

import java.sql.Timestamp;

public class Ccomment {

    private int pno;
    private int cno;
    private int ccno;
    private String ccid;
    private String ccment;
    private Timestamp ccdate;


    public Ccomment(int pno, int cno, int ccno, String ccid, String ccment, Timestamp ccdate) {
        super();
        this.pno = pno;
        this.cno = cno;
        this.ccno = ccno;
        this.ccid = ccid;
        this.ccment = ccment;
        this.ccdate = ccdate;
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


    public int getCcno() {
        return ccno;
    }


    public void setCcno(int ccno) {
        this.ccno = ccno;
    }


    public String getCcid() {
        return ccid;
    }


    public void setCcid(String ccid) {
        this.ccid = ccid;
    }


    public String getCcment() {
        return ccment;
    }


    public void setCcment(String ccment) {
        this.ccment = ccment;
    }


    public Timestamp getCcdate() {
        return ccdate;
    }


    public void setCcdate(Timestamp ccdate) {
        this.ccdate = ccdate;
    }


}
