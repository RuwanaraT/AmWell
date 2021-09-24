package com.example.doctorchannelingapp;

public class Channel {

    private int id;
    private String pName;
    private String pPhone;
    private String pNIC;
    private String pEmail;
    private String dName;
    private String Sep;

    public Channel() {

    }

    public Channel(int id, String pName, String pPhone, String pNIC, String pEmail, String dName, String sep) {
        this.id = id;
        this.pName = pName;
        this.pPhone = pPhone;
        this.pNIC = pNIC;
        this.pEmail = pEmail;
        this.dName = dName;
        Sep = sep;
    }

    public Channel(String pName, String pPhone, String pNIC, String pEmail, String dName, String sep) {
        this.pName = pName;
        this.pPhone = pPhone;
        this.pNIC = pNIC;
        this.pEmail = pEmail;
        this.dName = dName;
        Sep = sep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public String getpNIC() {
        return pNIC;
    }

    public void setpNIC(String pNIC) {
        this.pNIC = pNIC;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getSep() {
        return Sep;
    }

    public void setSep(String sep) {
        Sep = sep;
    }
}
