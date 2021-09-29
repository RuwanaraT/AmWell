package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PatientDashboard extends AppCompatActivity {

    Button btn_channel;
    Button btn_profile;
    Button btn_pay;
    Button btn_refund;
    TextView tv_upcoming;
    Context context;
    DBManager dbManager;

//    String eAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        btn_channel = findViewById(R.id.btn_channel);
        btn_profile = findViewById(R.id.btn_profile);
        btn_pay = findViewById(R.id.btn_payd);
        btn_refund = findViewById(R.id.btn_refund);
        tv_upcoming = findViewById(R.id.tv_upcoming);
        context = this;
        dbManager = new DBManager(context);

//        Intent intent = getIntent();
//
//        eAdd = intent.getStringExtra("refE");
//
//        int count = dbManager.countChannel(eAdd);
//        tv_upcoming.setText("You have "+count+" Upcoming Channel");
    }


    public void openChannelingForm(View view) {

        Intent intent = new Intent(this,ChannelingForm.class);

        startActivity(intent);
    }

    public void openPatientProfile(View view) {

        Intent intent = new Intent(this,PatientProfile.class);

        startActivity(intent);
    }

    public void openPaymentCard(View view) {

        Intent intent = new Intent(this,Payment.class);

        startActivity(intent);
    }

    public void openRefundForm(View view) {

        Intent intent = new Intent(this,RefundForm.class);

        startActivity(intent);
    }
}