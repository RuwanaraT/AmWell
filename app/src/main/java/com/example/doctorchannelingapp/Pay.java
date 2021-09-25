package com.example.doctorchannelingapp;

public class Pay {
    private int receipt_no;
    private String card_no;
    private String ex_year;
    private String ex_month;
    private String cvv;

    public Pay(){

    }

    public Pay(int receipt_no, String card_no, String ex_year, String ex_month, String cvv) {
        this.receipt_no = receipt_no;
        this.card_no = card_no;
        this.ex_year = ex_year;
        this.ex_month = ex_month;
        this.cvv = cvv;
    }

    public Pay(String card_no, String ex_year, String ex_month, String cvv) {
        this.card_no = card_no;
        this.ex_year = ex_year;
        this.ex_month = ex_month;
        this.cvv = cvv;
    }

    public int getReceipt_no() {
        return receipt_no;
    }

    public void setReceipt_no(int receipt_no) {
        this.receipt_no = receipt_no;
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
}
