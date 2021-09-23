package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChannelingReceipt extends AppCompatActivity {

    private TextView tv_refNo;
    private TextView tv_doctor;
    private TextView tv_special;

    String RefNo;
    String Doctor;
    String Special;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channeling_receipt);

        tv_refNo = findViewById(R.id.tv_refno);
        tv_doctor = findViewById(R.id.tv_doctor);
        tv_special = findViewById(R.id.tv_special);

        Intent intent = getIntent();

        // catch the values passed by intent
        RefNo = intent.getStringExtra("i1");
        Doctor = intent.getStringExtra("i2");
        Special = intent.getStringExtra("i3");

        // display text
        tv_refNo.setText(RefNo);
        tv_doctor.setText(Doctor);
        tv_special.setText(Special);
    }
}