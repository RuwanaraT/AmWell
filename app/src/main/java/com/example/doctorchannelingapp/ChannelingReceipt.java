package com.example.doctorchannelingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ChannelingReceipt extends AppCompatActivity {

    private TextView tv_refNo;
    private TextView tv_doctor;
    private TextView tv_special;
    private Button btn_update;
    Context context;
    DBManager dbManager;

    String RefNo;
    String Doctor;
    String Special;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channeling_receipt);

        tv_refNo = findViewById(R.id.tv_refno);
        tv_doctor = findViewById(R.id.tv_doctor);
        tv_special = findViewById(R.id.tv_special);
        btn_update = findViewById(R.id.btn_update);
        context = this;
        dbManager = new DBManager(context);

        Intent intent = getIntent();

        // catch the values passed by intent
        RefNo = intent.getStringExtra("i1");
        Doctor = intent.getStringExtra("i2");
        Special = intent.getStringExtra("i3");

        // display text
        tv_refNo.setText(RefNo);
        tv_doctor.setText(Doctor);
        tv_special.setText(Special);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Test");
                builder.setMessage("Message");

                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,PatientDashboard.class));
                    }
                });

                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dbManager.deleteChannel(RefNo);
                        startActivity(new Intent(context,PatientDashboard.class));
                    }
                });

                builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent1 = new Intent(context, UpdateChannelingForm.class);
                        intent1.putExtra("itm", RefNo);
                        startActivity(intent1);


                    }
                });

                builder.show();
            }
        });
    }
}