package com.example.doctorchannelingapp;

public class Refund {

    String id;
    String patient_name;
    String date;
    String receipt_no;
    String refund_amount;

    public Refund() {

    }

    public Refund(String id, String patient_name, String date, String receipt_no, String refund_amount) {
        this.id = id;
        this.patient_name = patient_name;
        this.date = date;
        this.receipt_no = receipt_no;
        this.refund_amount = refund_amount;
    }

    public Refund(String patient_name, String date, String receipt_no, String refund_amount) {
        this.patient_name = patient_name;
        this.date = date;
        this.receipt_no = receipt_no;
        this.refund_amount = refund_amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReceipt_no() {
        return receipt_no;
    }

    public void setReceipt_no(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }
}
