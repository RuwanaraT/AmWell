package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientDashboard extends AppCompatActivity {

    Button btn_channel;
    Button btn_channeling;
    Button btn_profile;
    //Button btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        btn_channel = findViewById(R.id.btn_channel);
        btn_channeling = findViewById(R.id.btn_channelings);
        btn_profile = findViewById(R.id.btn_profile);
        //btn_pay = findViewById(R.id.btn_payd);
    }

    public void openChannelingForm(View view) {

        Intent intent = new Intent(this,ChannelingForm.class);

        startActivity(intent);
    }

    public void openChannelingReceipt(View view) {

        Intent intent = new Intent(this,ChannelingReceipt.class);

        startActivity(intent);
    }

    public void openPatientProfile(View view) {

        Intent intent = new Intent(this,PatientProfile.class);

        startActivity(intent);
    }
}