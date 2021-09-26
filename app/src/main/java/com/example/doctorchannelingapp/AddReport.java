package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddReport extends AppCompatActivity {

    EditText name,nic,age,allergies,bgroup,weight,bp,bs;
    Button addreportbtn;

    ReportDBManager reportDBManager;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);

        name = findViewById(R.id.ar_pt1);
        nic = findViewById(R.id.ar_pt2);
        age = findViewById(R.id.ar_pt3);
        allergies = findViewById(R.id.ar_mltxt1);
        bgroup = findViewById(R.id.ar_bgrp);
        weight = findViewById(R.id.ar_tnum1);
        bp = findViewById(R.id.ar_tnum2);
        bs = findViewById(R.id.ar_tnum3);
        addreportbtn = findViewById(R.id.ar_sbmt);

        context = this;

        reportDBManager = new ReportDBManager(context);


        addreportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prname = name.getText().toString();
                String prnic = nic.getText().toString();
                String prage = age.getText().toString();
                String prallergies = allergies.getText().toString();
                String prbgroup = bgroup.getText().toString();
                String prweight = weight.getText().toString();
                String prbp = bp.getText().toString();
                String prbs = bs.getText().toString();

                Report report = new Report(prname,prnic,prage,prallergies,prbgroup,prweight,prbp,prbs);

                reportDBManager.addReport(report);

                startActivity(new Intent(context,ShowReport.class));
                Toast.makeText(context,"Report Successfully Added..",Toast.LENGTH_LONG).show();
            }
        });
    }
}