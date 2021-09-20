package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    EditText et_email;
//    EditText et_password;
//    RadioButton rd_btn_p;
//    RadioButton rd_btn_a;
      Button btn_login;
//    TextView tv_forget;
      TextView tv_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        et_email = findViewById(R.id.et_email);
//        et_password = findViewById(R.id.et_email);
//        rd_btn_p = findViewById(R.id.rd_btn_p);
//        rd_btn_a = findViewById(R.id.rd_btn_a);
          btn_login = findViewById(R.id.btn_login);
//        tv_forget = findViewById(R.id.tv_forgot);
          tv_signup = findViewById(R.id.tv_signup);

//        tv_signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void openRegistration(View view) {

        Intent intent = new Intent(this,PatientRegistration.class);

        startActivity(intent);
    }

    public void openPatientDashboard(View view) {

        Intent intent = new Intent(this,PatientDashboard.class);

        startActivity(intent);
    }
}