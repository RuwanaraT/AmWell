package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DoctorDb extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static String DB_NAME="doctorhandeling";
    private static String TABLE_NAME="doctor";

    //column name
    private static final String ID="id";
    private static final String NAME="name";
    private static final String SPECIALIZATION="specialization";
    private static final String TIME="time";
    private static final String NUMBER="number";


    public DoctorDb(@Nullable Context context) {
        super(context, DB_NAME, null,VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY="CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" TEXT,"
                +SPECIALIZATION+" TEXT,"
                +TIME+" TEXT,"
                +NUMBER+" TEXT"+
                ");";

//        CREATE TABLE doctor(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,specialization TEXT,time TEXT,number TEXT);

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_TABLE_QUERY="DROP TABLE IF EXISTS "+ TABLE_NAME;
        //drop older table
        db.execSQL(DROP_TABLE_QUERY);
        //create table again
        onCreate(db);

    }

    //Insert data to database
    public void addDoctor(Doctor doctor){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();//getwritableDatabase()->can write data in the database
        ContentValues contentValues=new ContentValues();//to save data in the database
        contentValues.put(NAME,doctor.getName());
        contentValues.put(SPECIALIZATION,doctor.getSpecialization());
        contentValues.put(TIME,doctor.getTime());
        contentValues.put(NUMBER,doctor.getnumber());

        //save data in table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();



    }

    //count table records
    public int countDoctors(){
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        return  cursor.getCount();
    }

    //get all doctor details
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);

        //check first raw empty or not
        if(cursor.moveToFirst()){
            do{
                Doctor doctor=new Doctor();
                doctor.setId(cursor.getInt(0));
                doctor.setName(cursor.getString(1));
                doctor.setSpecialization(cursor.getString(2));
                doctor.setTime(cursor.getString(3));
                doctor.setnumber(cursor.getString(4));

                doctors.add(doctor);

            }while (cursor.moveToNext());
        }

        return doctors;
    }

    //delete items
    public void deleteDoctors(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME,ID+" =?",new String[]{String.valueOf(id)});
        db.close();

    }

    //get data to edit page
    public Doctor getDoctorEdit(int id){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor= db.query(TABLE_NAME,new String[]{ID,NAME,SPECIALIZATION,TIME,NUMBER},ID+" =?",new String[]{String.valueOf(id)},null,null,null);

        Doctor doctor;
        if(cursor != null){
            cursor.moveToFirst();
            doctor=new Doctor(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return doctor;
        }
        return null;
    }

    //update method

    public int updateDoctor(Doctor doctor){

        SQLiteDatabase db=getWritableDatabase();

        ContentValues contentValues=new ContentValues();//to save data in the database
        contentValues.put(NAME,doctor.getName());
        contentValues.put(SPECIALIZATION,doctor.getSpecialization());
        contentValues.put(TIME,doctor.getTime());
        contentValues.put(NUMBER,doctor.getnumber());

        int status=db.update(TABLE_NAME,contentValues,ID+" =?",new String[]{String.valueOf(doctor.getId())});

        db.close();
        return status;

    }

}


