package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateReport extends AppCompatActivity {

    EditText name,nic,age,allergies,bgroup,weight,bp,bs;
    Button updatereportbtn;

    ReportDBManager reportDBManager;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_report);

        name = findViewById(R.id.ur_pt1);
        nic = findViewById(R.id.ur_pt2);
        age = findViewById(R.id.ur_pt3);
        allergies = findViewById(R.id.ur_mltxt1);
        bgroup = findViewById(R.id.ur_bgrp);
        weight = findViewById(R.id.ur_tnum1);
        bp = findViewById(R.id.ur_tnum2);
        bs = findViewById(R.id.ur_tnum3);
        updatereportbtn = findViewById(R.id.ur_update);

        context = this;

        reportDBManager = new ReportDBManager(context);

        String id = getIntent().getStringExtra("id");

        Report report = reportDBManager.getUpdateData(Integer.parseInt(id));

        name.setText(report.getName());
        nic.setText(report.getNic());
        age.setText(report.getAge());
        allergies.setText(report.getAllerg());
        bgroup.setText(report.getBgroup());
        weight.setText(report.getWeight());
        bp.setText(report.getBpsr());
        bs.setText(report.getBsugar());
        System.out.println(id);

        updatereportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rname = name.getText().toString();
                String rnic = nic.getText().toString();
                String rage = age.getText().toString();
                String rallergies = allergies.getText().toString();
                String rbgroup = bgroup.getText().toString();
                String rweight = weight.getText().toString();
                String rbp = bp.getText().toString();
                String rbs = bs.getText().toString();

                Report sreport = new Report(Integer.parseInt(id),rname,rnic,rage,rallergies,rbgroup,rweight,rbp,rbs);
                int sendreport = reportDBManager.updateReport(sreport);

                if(sendreport==1){
                    Toast.makeText(context,"Report Successfully Updated..",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"Report not Updated..",Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(context,ReportList.class));

            }
        });

    }
}