package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PatientRegistration extends AppCompatActivity {

//    EditText et_reg_name;
//    EditText et_reg_gender;
//    EditText et_reg_nic;
//    EditText et_reg_bdy;
//    EditText et_reg_con;
//    EditText et_reg_email;
//    EditText et_reg_address;
//    EditText et_reg_pass;
//    EditText et_reg_repass;
//    Button btn_submit;
    Button btn_reg_cancel;
    //TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

//        et_reg_name = findViewById(R.id.et_regname);
//        et_reg_gender = findViewById(R.id.et_reggender);
//        et_reg_nic = findViewById(R.id.et_regnic);
//        et_reg_bdy = findViewById(R.id.et_regbdy);
//        et_reg_con = findViewById(R.id.et_regcon);
//        et_reg_email = findViewById(R.id.et_regemail);
//        et_reg_address = findViewById(R.id.et_regaddress);
//        et_reg_pass = findViewById(R.id.et_regpass);
//        et_reg_repass = findViewById(R.id.et_repass);
//        btn_submit = findViewById(R.id.btn_submit);
      btn_reg_cancel = findViewById(R.id.btn_regcancel);
//      tv_login = findViewById(R.id.tv_loglink);
    }

    public void openLogin(View view) {

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }
}