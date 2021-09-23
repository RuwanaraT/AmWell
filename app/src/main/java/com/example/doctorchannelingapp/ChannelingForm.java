package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class ChannelingForm extends AppCompatActivity {

    private EditText et_pName;
    private EditText et_phone;
    private EditText et_pNIC;
    private EditText et_pEmail;
    private EditText et_dName;
    private EditText et_sep;
    private Button btn_confirm;
    private Button btn_cancel;
    Context context;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channeling_form);

        et_pName = findViewById(R.id.et_pname);
        et_phone = findViewById(R.id.et_phone);
        et_pNIC = findViewById(R.id.et_pnic);
        et_pEmail = findViewById(R.id.et_pemail);
        et_dName = findViewById(R.id.et_dname);
        et_sep = findViewById(R.id.et_sep);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_cancel = findViewById(R.id.btn_cancel);
        context = this;
        dbManager = new DBManager(context);
    }

    // onclick method for confirm button
    public void openChannelingReceipt(View view) {

        String ip_name = et_pName.getText().toString();
        String ip_phone = et_phone.getText().toString();
        String ip_nic = et_pNIC.getText().toString();
        String ip_email = et_pEmail.getText().toString();
        String ip_doc = et_dName.getText().toString();
        String ip_sep = et_sep.getText().toString();

        if(ip_name.equals("") || ip_phone.equals("") || ip_nic.equals("") || ip_email.equals("") || ip_doc.equals("") || ip_sep.equals("")) {

            Toast.makeText(this, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
        }
        else {

             Channel channel = new Channel(ip_name, ip_phone, ip_nic, ip_email, ip_doc, ip_sep);
             Boolean result = dbManager.addChannel(channel);

             if(result == false) {

                 Toast.makeText(context, "Channel is confirmed", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(this,ChannelingReceipt.class);

                 intent.putExtra("i1", ip_nic);
                 intent.putExtra("i2", ip_doc);
                 intent.putExtra("i3", ip_sep);
                 startActivity(intent);
             }
             else {

                 Toast.makeText(context, "Something might went wrong", Toast.LENGTH_SHORT).show();
             }
        }


    }

    // onclick method for cancel button
    public void cancelChannelingReceipt(View view) {

        Intent intent = new Intent(this, PatientDashboard.class);

        startActivity(intent);
    }
}