package com.example.awstest2.model;

public class Couple {

    private int couplenum;
    private String mid;
    private String did;

    private String city;

    private String village;

    public Couple(int couplenum, String mid, String did, String city, String village) {
        this.couplenum = couplenum;
        this.mid = mid;
        this.did = did;
        this.city = city;
        this.village = village;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}
