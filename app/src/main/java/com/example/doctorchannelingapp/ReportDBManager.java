package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    //to display the report list in the admin Patient Reports page
    public List<Report> getReport(){
        List<Report> reports = new ArrayList<>();
        SQLiteDatabase sqldb = getReadableDatabase();//Object to read the data from the database
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqldb.rawQuery(query,null);

        //to check if the 1st row is empty
        if(cursor.moveToFirst()){
            do {
                Report report = new Report();
                report.setId(cursor.getInt(0));
                report.setName(cursor.getString(1));
                report.setNic(cursor.getString(2));
                report.setAge(cursor.getString(3));
                report.setAllerg(cursor.getString(4));
                report.setBgroup(cursor.getString(5));
                report.setWeight(cursor.getString(6));
                report.setBpsr(cursor.getString(7));
                report.setBsugar(cursor.getString(8));

                reports.add(report);
            }while(cursor.moveToNext());
        }

        return reports;
    }

    //To Delete a report
    public void deleteReport(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,ID+" =?",new String[]{String.valueOf(id)});
        db.close();
    }
    //To get the data to the Update form
    public Report getUpdateData(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,NAME,NIC,AGE,ALLERG,BGROUP,WEIGHT,BPSR,BSUGAR},ID+" =?",
                new String[]{String.valueOf(id)},null,null,null);
        Report report;
        if(cursor != null){
            cursor.moveToFirst();
            report = new Report(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)
            );
            return report;
        }
        return null;
    }
    //To Update a Report
    public int updateReport(Report sreport){

        SQLiteDatabase db = getWritableDatabase(); //object to insert data into the Database
        ContentValues content = new ContentValues();  // to save data in the database

        //taking the data values from the report object and passing to the table
        content.put(NAME,sreport.getName());
        content.put(NIC,sreport.getNic());
        content.put(AGE,sreport.getAge());
        content.put(ALLERG,sreport.getAllerg());
        content.put(BGROUP,sreport.getBgroup());
        content.put(WEIGHT,sreport.getWeight());
        content.put(BPSR,sreport.getBpsr());
        content.put(BSUGAR,sreport.getBsugar());

        int reports = db.update(TABLE_NAME,content,ID+" =?",new String[]{String.valueOf(sreport.getId())});
        return reports;
    }
}
