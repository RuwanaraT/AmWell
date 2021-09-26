package com.example.doctorchannelingapp;

public class Pay {
    private int id;
    private String card_no;
    private String ex_year;
    private String ex_month;
    private String cvv;
    private String amount;


    public Pay(){

    }

    public Pay(int id, String card_no, String ex_year, String ex_month, String cvv, String amount) {
        this.id = id;
        this.card_no = card_no;
        this.ex_year = ex_year;
        this.ex_month = ex_month;
        this.cvv = cvv;
        this.amount = amount;
    }

    public Pay(String card_no, String ex_year, String ex_month, String cvv, String amount) {
        this.card_no = card_no;
        this.ex_year = ex_year;
        this.ex_month = ex_month;
        this.cvv = cvv;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getEx_year() {
        return ex_year;
    }

    public void setEx_year(String ex_year) {
        this.ex_year = ex_year;
    }

    public String getEx_month() {
        return ex_month;
    }

    public void setEx_month(String ex_month) {
        this.ex_month = ex_month;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
