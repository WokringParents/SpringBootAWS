package com.example.awstest2.model;

public class Couple {

    private int couplenum;
    private String mid;
    private String did;

    private String spousename;

    public Couple(int couplenum, String mid, String did) {
        this.couplenum = couplenum;
        this.mid = mid;
        this.did = did;
    }

    public Couple(Couple selectCouple) {
        this.couplenum=selectCouple.couplenum;
        this.mid=selectCouple.mid;
        this.did=selectCouple.did;
        this.spousename=null;
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
