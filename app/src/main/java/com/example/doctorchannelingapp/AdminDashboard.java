package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

    Button docDetail,addreport,updtereport;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        docDetail=findViewById(R.id.adm_btn1);
        addreport=findViewById(R.id.button3);
        updtereport=findViewById(R.id.button4);
        context=this;

        docDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context,DoctorMain.class));
            }
        });
    }
}