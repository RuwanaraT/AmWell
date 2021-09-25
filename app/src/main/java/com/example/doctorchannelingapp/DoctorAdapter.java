package com.example.doctorchannelingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DoctorAdapter extends ArrayAdapter<Doctor> {

    private Context context;
    private int resource;
    List<Doctor> doctors;

    DoctorAdapter(Context context, int resource, List<Doctor> doctors){
        super(context,resource,doctors);
        this.context=context;
        this.resource=resource;
        this.doctors=doctors;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(resource,parent,false);

        TextView name=row.findViewById(R.id.name);
        TextView specialization=row.findViewById(R.id.specialization);
        TextView time=row.findViewById(R.id.time);
        TextView number=row.findViewById(R.id.tpnumber);
        ImageView profile=row.findViewById(R.id.profileImg);

        Doctor doctor=doctors.get(position);

        name.setText(doctor.getName());
        specialization.setText(doctor.getSpecialization());
        time.setText(doctor.getTime());
        number.setText(doctor.getnumber());
        profile.setVisibility(row.VISIBLE);

        return row;
    }

}

