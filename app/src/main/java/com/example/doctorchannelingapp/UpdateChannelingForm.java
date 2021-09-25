package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateChannelingForm extends AppCompatActivity {

    EditText updatePName;
    EditText updatePhone;
    EditText updatePNIC;
    EditText updatePEmail;
    EditText updateDName;
    EditText updateSep;
    Button UEdit;
    Button updateCancel;
    private List<Channel> channels;
    Context context;
    DBManager dbManager;

    String PatientNic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_channeling_form);

        updatePName = findViewById(R.id.et_updatePName);
        updatePhone = findViewById(R.id.et_updatePhone);
        updatePNIC = findViewById(R.id.et_updatePNIC);
        updatePEmail = findViewById(R.id.et_updatePEmail);
        updateDName = findViewById(R.id.et_updateDName);
        updateSep = findViewById(R.id.et_updateSep);
        UEdit = findViewById(R.id.btn_UEdit);
        updateCancel = findViewById(R.id.btn_updateCancel);
        context = this;
        dbManager = new DBManager(context);

        channels = dbManager.getAllToDos();

        Intent intent = getIntent();

        PatientNic = intent.getStringExtra("itm");

        Channel channel = dbManager.getSingleChannel(PatientNic);

        // set text
        updatePName.setText(channel.getpName());
        updatePhone.setText(channel.getpPhone());
        updatePNIC.setText(channel.getpNIC());
        updatePEmail.setText(channel.getpEmail());
        updateDName.setText(channel.getdName());
        updateSep.setText(channel.getSep());

        UEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String upName = updatePName.getText().toString();
                String uPhone = updatePhone.getText().toString();
                String uPNic = updatePNIC.getText().toString();
                String uEmail = updatePEmail.getText().toString();
                String uDName = updateDName.getText().toString();
                String uSep = updateSep.getText().toString();

                Channel channel1 = new Channel(channel.getId(), upName, uPhone, uPNic, uEmail, uDName, uSep);
                Boolean status = dbManager.updateSingleChannel(channel1);

                if(status == true) {

                    Toast.makeText(context, "Channel has been Updated", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(context, ChannelingReceipt.class);
                    intent1.putExtra("i1", uPNic);
                    intent1.putExtra("i2", uDName);
                    intent1.putExtra("i3", uSep);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(context, "Update is not Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        updateCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,PatientDashboard.class));
            }
        });
    }
}