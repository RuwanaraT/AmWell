package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ReportDBManager extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "reporthandling";
    private static final String TABLE_NAME = "report";

    // Report Table column names
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String NIC = "nic";
    private static final String AGE = "age";
    private static final String ALLERG = "allerg";
    private static final String BGROUP = "bgroup";
    private static final String WEIGHT = "weight";
    private static final String BPSR = "bpsr";
    private static final String BSUGAR = "bsugar";

    public ReportDBManager(@Nullable Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" TEXT,"
                +NIC+" TEXT,"
                +AGE+" TEXT,"
                +ALLERG+" TEXT,"
                +BGROUP+" TEXT,"
                +WEIGHT+" TEXT,"
                +BPSR+" TEXT,"
                +BSUGAR+" TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_QUERY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // create tables again
        onCreate(db);
    }

    public void addReport(Report report){

        SQLiteDatabase sqldb = getWritableDatabase(); //object to insert data into the Database
        ContentValues content = new ContentValues();  // to save data in the database

        //taking the data values from the report object and passing to the table
        content.put(NAME,report.getName());
        content.put(NIC,report.getNic());
        content.put(AGE,report.getAge());
        content.put(ALLERG,report.getAllerg());
        content.put(BGROUP,report.getBgroup());
        content.put(WEIGHT,report.getWeight());
        content.put(BPSR,report.getBpsr());
        content.put(BSUGAR,report.getBsugar());

        //To save to the database table
        sqldb.insert(TABLE_NAME,null,content);
        sqldb.close();// to close the DB

    }
}
