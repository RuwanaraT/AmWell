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

public class PatientRegistration extends AppCompatActivity {

   private EditText et_reg_name;
   private EditText et_reg_gender;
   private EditText et_reg_nic;
   private EditText et_reg_bdy;
   private EditText et_reg_con;
   private EditText et_reg_email;
   private EditText et_reg_address;
   private EditText et_reg_pass;
   private EditText et_reg_repass;
   private Button btn_submit;
   private Button btn_reg_cancel;
   private Context context;
   private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        et_reg_name = findViewById(R.id.et_regname);
        et_reg_gender = findViewById(R.id.et_reggender);
        et_reg_nic = findViewById(R.id.et_regnic);
        et_reg_bdy = findViewById(R.id.et_regbdy);
        et_reg_con = findViewById(R.id.et_regcon);
        et_reg_email = findViewById(R.id.et_regemail);
        et_reg_address = findViewById(R.id.et_regaddress);
        et_reg_pass = findViewById(R.id.et_regpass);
        et_reg_repass = findViewById(R.id.et_repass);
        btn_submit = findViewById(R.id.btn_submit);
        btn_reg_cancel = findViewById(R.id.btn_regcancel);
        context = this;
        dbManager = new DBManager(context);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String iName = et_reg_name.getText().toString();
                String iGender = et_reg_gender.getText().toString();
                String iNIC = et_reg_nic.getText().toString();
                String iBdy = et_reg_bdy.getText().toString();
                String iPhone = et_reg_con.getText().toString();
                String iEmail = et_reg_email.getText().toString();
                String iAddress = et_reg_address.getText().toString();
                String iPassword = et_reg_pass.getText().toString();
                String iRePassword = et_reg_repass.getText().toString();

                if(iName.equals("") || iGender.equals("") || iNIC.equals("") || iBdy.equals("") || iPhone.equals("") || iEmail.equals("") || iAddress.equals("") || iPassword.equals("") || iRePassword.equals("")) {

                    Toast.makeText(context, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
                }

                else {

                    if(iPassword.equals(iRePassword)) {

                        Boolean result = dbManager.ValidateEmail(iEmail);

                        if(result == false) {

                            Patient patient = new Patient(iName, iGender, iNIC, iBdy, iPhone, iEmail, iAddress, iPassword, iRePassword);
                            Boolean status = dbManager.PatientRegistration(patient);

                            if(status == true) {

                                Toast.makeText(context, "Registration is Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(context, MainActivity.class));
                            }
                            else {
                                Toast.makeText(context, "Registration is Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(context, "Email is Already Exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(context, "Two Password Fields are Mismatched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void openLogin(View view) {

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }
}