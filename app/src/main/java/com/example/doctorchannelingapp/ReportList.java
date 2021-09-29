package com.example.doctorchannelingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ReportList extends AppCompatActivity {

    private ListView listview;
    private ReportDBManager report;
    Context context;
    List<Report> reports;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_list);

        listview = findViewById(R.id.replist);
        context = this;
        report = new ReportDBManager(this);
        reports = new ArrayList<>();

        //get all reports
        reports = report.getReport();

        ReportAdapter reportAdapter = new ReportAdapter(context,R.layout.reportlist,reports);
        listview.setAdapter(reportAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Report reportact = reports.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(reportact.getName());
                builder.setMessage("Select Action..");

                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        report.deleteReport(reportact.getId());
                        startActivity(new Intent(context,ReportList.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        startActivity(new Intent(context,UpdateReport.class));

                        Intent intent = new Intent(context,UpdateReport.class);
                        intent.putExtra("id",String.valueOf(reportact.getId()));
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });
    }
}