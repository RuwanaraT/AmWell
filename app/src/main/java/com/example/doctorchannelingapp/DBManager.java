package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class DBManager extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE = "amWell";
    private static final String TABLE_NAME = "patient";
    private static final String TABLE_NAME_1 = "channel";

    // patient table's column names
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String NIC = "nic";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String PASSWORD = "password";
    private static final String RE_PASSWORD = "re_password";

    // channel table's column names
    private static final String PID = "pid";
    private static final String P_NAME = "p_name";
    private static final String P_NUMBER = "p_number";
    private static final String P_NIC = "p_nic";
    private static final String P_EMAIL = "p_email";
    private static final String DOCTOR = "doctor";
    private static final String SPECIALIZATION = "specialization";


    public DBManager(@Nullable Context context) { super(context, DATABASE, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // channel table create query
        String TABLE_CHANNEL_QUERY = "CREATE TABLE "+TABLE_NAME_1+" " +
                "("
                +PID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +P_NAME + " TEXT,"
                +P_NUMBER + " TEXT,"
                +P_NIC + " TEXT,"
                +P_EMAIL+ " TEXT,"
                +DOCTOR + " TEXT,"
                +SPECIALIZATION+" TEXT" +
                ");";

        // run the create query
        db.execSQL(TABLE_CHANNEL_QUERY);

        // patient table create query
        String TABLE_PATIENT_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME + " TEXT,"
                +GENDER + " TEXT,"
                +NIC + " TEXT,"
                +PHONE + " TEXT,"
                +EMAIL + " TEXT,"
                +ADDRESS + " TEXT,"
                +PASSWORD + " TEXT,"
                +RE_PASSWORD+" TEXT" +
                ");";

        // run the create query
        db.execSQL(TABLE_PATIENT_QUERY);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drop table query for channel table
        String DROP_TABLE_QUERY_1 = "DROP TABLE IF EXISTS " + TABLE_NAME_1;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY_1);

        // drop table query for patient table
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);


        // create tables again
        onCreate(db);
    }

    // method for patient registration
    public Boolean PatientRegistration(Patient patient) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,patient.getName());
        contentValues.put(GENDER, patient.getGender());
        contentValues.put(NIC, patient.getNic());
        contentValues.put(PHONE, patient.getPhone());
        contentValues.put(EMAIL, patient.getEmail());
        contentValues.put(ADDRESS, patient.getAddress());
        contentValues.put(PASSWORD, patient.getPassword());
        contentValues.put(RE_PASSWORD, patient.getRePassword());

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // method for validate email address
    public Boolean ValidateEmail(String email) {

        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM patient WHERE email = ?",new String[] {email});

        if(cursor.getCount() > 0) {

            return true;
        }
        else {

            return false;
        }
    }

    // method for validate email and password together
    public boolean ValidatePatient(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM patient WHERE email = ? and password = ?", new String[] {email, password});

        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    // method for inset channel
    public void addChannel(Channel channel) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(P_NAME, channel.getpName());
        contentValues.put(P_NUMBER, channel.getpPhone());
        contentValues.put(P_NIC, channel.getpNIC());
        contentValues.put(P_EMAIL, channel.getpEmail());
        contentValues.put(DOCTOR, channel.getdName());
        contentValues.put(SPECIALIZATION, channel.getSep());

        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        sqLiteDatabase.close();

    }

    // method for delete channel
    public void deleteChannel(String refNo) {

        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_NAME_1, "p_nic = ?", new String[] {refNo});
        db.close();
    }

    // get all channels
    public List<Channel> getAllToDos(){

        List<Channel> channels = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME_1;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                // Create new channel object
                Channel channel = new Channel();

                channel.setId(cursor.getInt(0));
                channel.setpName(cursor.getString(1));
                channel.setpPhone(cursor.getString(2));
                channel.setpNIC(cursor.getString(3));
                channel.setdName(cursor.getString(4));
                channel.setSep(cursor.getString(4));

                channels.add(channel);
            }while (cursor.moveToNext());
        }
        return channels;
    }

    // get a single channel
    public Channel getSingleChannel(String id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME_1,new String[]{PID,P_NAME,P_NUMBER,P_NIC,P_EMAIL,DOCTOR,SPECIALIZATION},
                P_NIC + "= ?",new String[]{id}
                ,null,null,null);

        Channel channel;
        if(cursor != null){
            cursor.moveToFirst();
            channel = new Channel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            );
            return channel;
        }
        return null;
    }

    // method for update single channel
    public boolean updateSingleChannel(Channel channel){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(P_NAME,channel.getpName());
        contentValues.put(P_NUMBER, channel.getpPhone());
        contentValues.put(P_NIC, channel.getpNIC());
        contentValues.put(P_EMAIL, channel.getpEmail());
        contentValues.put(P_EMAIL, channel.getpEmail());
        contentValues.put(DOCTOR, channel.getdName());
        contentValues.put(SPECIALIZATION, channel.getSep());

        int status = db.update(TABLE_NAME_1,contentValues,PID +" =?",
                new String[]{String.valueOf(channel.getId())});

        if(status > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
