package com.example.awstest2.model;

import java.sql.Timestamp;

public class CoupleCode {

    private String code;
    private Timestamp ctime;
    private String cid;

    public CoupleCode(String code, Timestamp ctime, String cid) {
        this.code = code;
        this.ctime = ctime;
        this.cid = cid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getCtime() {
        return ctime;
    }

    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
