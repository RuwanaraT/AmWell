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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DoctorMain extends AppCompatActivity {

    private Button add,view;
    private ListView listView;
    private TextView count;
    Context context;
    private DoctorDb doctorDb;
    private List<Doctor> doctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.add);
        view=findViewById(R.id.view);
        listView=findViewById(R.id.doclict);
        count=findViewById(R.id.doccount);
        context=this;
        doctorDb=new DoctorDb(this);
        doctors=new ArrayList<>();

        //store data
        doctors=doctorDb.getAllDoctors();
        DoctorAdapter doctorAdapter=new DoctorAdapter(context,R.layout.singledoc,doctors);
        listView.setAdapter(doctorAdapter);

        //get doctor count
        int countDoc=doctorDb.countDoctors();
        count.setText(countDoc+ " Doctors in");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context,AddDoctor.class));
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Doctor doctor=doctors.get(position);


                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle(doctor.getName());
                builder.setMessage(doctor.getSpecialization());


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        doctorDb.deleteDoctors(doctor.getId());
                        startActivity(new Intent(context,DoctorMain.class));

                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(context,EditDoctor.class);
                        intent.putExtra("id",String.valueOf(doctor.getId()));
                        startActivity(intent);

//                       startActivity(new Intent(context,EditDoctor.class));

                    }
                });
                builder.show();

            }
        });

    }

}