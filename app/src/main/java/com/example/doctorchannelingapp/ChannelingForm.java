package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChannelingForm extends AppCompatActivity {

    Button btn_confirm;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channeling_form);

        btn_confirm = findViewById(R.id.btn_confirm);
        btn_cancel = findViewById(R.id.btn_cancel);
    }

    public void openChannelingReceipt(View view) {

        Intent intent = new Intent(this,ChannelingReceipt.class);

        startActivity(intent);
    }

    public void cancelChannelingReceipt(View view) {

        Intent intent = new Intent(this, PatientDashboard.class);

        startActivity(intent);
    }
}