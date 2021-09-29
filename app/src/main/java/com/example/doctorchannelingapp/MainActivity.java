package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

      EditText et_email;
      EditText et_password;
      RadioButton rd_btn_p;
//    RadioButton rd_btn_a;
      Button btn_login;
//    TextView tv_forget;
      TextView tv_signup;
      Context context;
      DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          et_email = findViewById(R.id.et_email);
          et_password = findViewById(R.id.et_password);
          rd_btn_p = findViewById(R.id.rd_btn_p);
//        rd_btn_a = findViewById(R.id.rd_btn_a);
          btn_login = findViewById(R.id.btn_login);
//        tv_forget = findViewById(R.id.tv_forgot);
          tv_signup = findViewById(R.id.tv_signup);
          context = this;
          dbManager = new DBManager(context);

          // login button
          btn_login.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  if(rd_btn_p.isChecked()) {

                      String iEmail = et_email.getText().toString();
                      String iPassword = et_password.getText().toString();

                      if(iEmail.equals("") || iPassword.equals("")) {

                          Toast.makeText(context, "Please Provide Email and Password", Toast.LENGTH_SHORT).show();
                      }

                      else {

                          Boolean result = dbManager.ValidatePatient(iEmail, iPassword);

                          if(result==true) {

                              Intent intent = new Intent(getApplicationContext(),PatientDashboard.class);
                              intent.putExtra("refE", iEmail);
                              startActivity(intent);
                          }

                          else {

                              Toast.makeText(context, "Email and Password are Invalid", Toast.LENGTH_SHORT).show();
                          }
                      }

                  }
              }
          });

    }

    // method for open patient registration form
    public void openRegistration(View view) {

        Intent intent = new Intent(this,PatientRegistration.class);

        startActivity(intent);
    }

}