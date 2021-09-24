package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDoctor extends AppCompatActivity {
        private EditText name,spec,time,number;
        private Button add;
        private DoctorDb doctorDb;
        private Context context;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_doctor);

            name=findViewById(R.id.editTextName);
            spec=findViewById(R.id.editTextSpecialization);
            time=findViewById(R.id.editTextTime);
            number=findViewById(R.id.editTexttpnumber);
            add=findViewById(R.id.buttonAdd);
            context=this;

            doctorDb=new DoctorDb(context);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String docName=name.getText().toString();
                    String docSpec=spec.getText().toString();
                    String docTime=time.getText().toString();
                    String docNumber=number.getText().toString();

                    Doctor doctor=new Doctor(docName,docSpec,docTime,docNumber);
                    doctorDb.addDoctor(doctor);

                    startActivity(new Intent(context,DoctorMain.class));


                }
            });
        }

    }

















