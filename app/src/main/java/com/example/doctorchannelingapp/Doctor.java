package com.example.doctorchannelingapp;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String time;
    private String number;

    public Doctor(){

    }
    public Doctor(int id, String name, String specialization, String time, String number) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.time = time;
        this.number = number;
    }

    public Doctor(String name, String specialization, String time, String number) {
        this.name = name;
        this.specialization = specialization;
        this.time = time;
        this.number = number;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getnumber() {
        return number;
    }

    public void setnumber(String number) {
        this.number = number;
    }
}



