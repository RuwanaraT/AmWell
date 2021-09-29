package com.example.doctorchannelingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ReportAdapter extends ArrayAdapter<Report> {

    private Context context;
    private int resource;
    List<Report> reports;


    ReportAdapter(@NonNull Context context, int resource, List<Report> reports) {
        super(context, resource, reports);

        this.context = context;
        this.resource = resource;
        this.reports = reports;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);
        TextView name = row.findViewById(R.id.rlname);
        TextView nic = row.findViewById(R.id.rlnic);

        Report report = reports.get(position);
        name.setText(report.getName());
        nic.setText(report.getNic());

        return row;

    }
}
