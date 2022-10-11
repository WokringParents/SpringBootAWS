package com.example.awstest2.model;

public class Couple {

    private int couplenum;
    private String mid;
    private String did;

    private String spousename;

    public Couple(int couplenum, String mid, String did, String spousename) {
        this.couplenum = couplenum;
        this.mid = mid;
        this.did = did;
        this.spousename=spousename;
    }

    public int getCouplenum() {
        return couplenum;
    }

    public void setCouplenum(int couplenum) {
        this.couplenum = couplenum;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getSpousename() {
        return spousename;
    }

    public void setSpousename(String spousename) {
        this.spousename = spousename;
    }
}
