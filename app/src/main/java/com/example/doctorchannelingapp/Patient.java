package com.example.doctorchannelingapp;

public class Patient {

    private int id;
    private String name;
    private String gender;
    private String nic;
    private String bdy;
    private String phone;
    private String email;
    private String address;
    private String password;
    private String rePassword;

    public Patient() {

    }

    public Patient(int id, String name, String gender, String nic, String bdy, String phone, String email, String address, String password, String rePassword) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.nic = nic;
        this.bdy = bdy;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
        this.rePassword = rePassword;
    }

    public Patient(String name, String gender, String nic, String bdy, String phone, String email, String address, String password, String rePassword) {
        this.name = name;
        this.gender = gender;
        this.nic = nic;
        this.bdy = bdy;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
        this.rePassword = rePassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBdy() {
        return bdy;
    }

    public void setBdy(String bdy) {
        this.bdy = bdy;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
