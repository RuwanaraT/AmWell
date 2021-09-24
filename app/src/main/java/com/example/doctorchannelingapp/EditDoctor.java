package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDoctor extends AppCompatActivity {

    private EditText name,spe,time,number;
    private Button edit;
    private DoctorDb doctorDb;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_doctor);



        name=findViewById(R.id.editDocTextName);
        spe=findViewById(R.id.editDocTextSpecialization);
        time=findViewById(R.id.editDocTextTime);
        number=findViewById(R.id.editDocTexttpnumber);
        edit=findViewById(R.id.buttonEdit);
        context=this;
        doctorDb=new DoctorDb(context);

        final String id=getIntent().getStringExtra("id");
        Doctor doctor=doctorDb.getDoctorEdit(Integer.parseInt(id));

        name.setText(doctor.getName());
        spe.setText(doctor.getSpecialization());
        time.setText(doctor.getTime());
        number.setText(doctor.getnumber());
        System.out.println(id);

        //to update
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Docname=name.getText().toString();
                String Docspe=spe.getText().toString();
                String Doctime=time.getText().toString();
                String Docnumber=number.getText().toString();

                Doctor doctor =new Doctor(Integer.parseInt(id),Docname,Docspe,Doctime,Docnumber);
                int state=doctorDb.updateDoctor(doctor);
                if(state==1){
                    Toast toast = Toast.makeText(context, "Update Success..", Toast.LENGTH_LONG);
                    toast.show();

                }
                startActivity(new Intent(context,DoctorMain.class));
            }
        });
    }
}







