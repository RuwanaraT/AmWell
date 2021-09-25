package com.example.doctorchannelingapp;

public class Report {

    private int id;
    private String name;
    private String nic;
    private String age;
    private String allerg;
    private String bgroup;
    private String weight;
    private String bpsr;
    private String bsugar;

    public Report(){};

    public Report(int id, String name, String nic, String age, String allerg,String bgroup, String weight, String bpsr, String bsugar) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.age = age;
        this.allerg = allerg;
        this.bgroup = bgroup;
        this.weight = weight;
        this.bpsr = bpsr;
        this.bsugar = bsugar;
    }

    public Report(String name, String nic, String age, String allerg,String bgroup, String weight, String bpsr, String bsugar) {
        this.name = name;
        this.nic = nic;
        this.age = age;
        this.allerg = allerg;
        this.bgroup = bgroup;
        this.weight = weight;
        this.bpsr = bpsr;
        this.bsugar = bsugar;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAllerg() {
        return allerg;
    }

    public void setAllerg(String allerg) {
        this.allerg = allerg;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBpsr() {
        return bpsr;
    }

    public void setBpsr(String bpsr) {
        this.bpsr = bpsr;
    }

    public String getBsugar() {
        return bsugar;
    }

    public void setBsugar(String bsugar) {
        this.bsugar = bsugar;
    }
}
