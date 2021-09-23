package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final int VERSION = 1;
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
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drop table query for patient table
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);

        // drop table query for channel table
        String DROP_TABLE_QUERY_1 = "DROP TABLE IF EXISTS " + TABLE_NAME_1;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY_1);

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
    public Boolean addChannel(Channel channel) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(P_NAME, channel.getpName());
        contentValues.put(P_NUMBER, channel.getpPhone());
        contentValues.put(P_NIC, channel.getpNIC());
        contentValues.put(P_EMAIL, channel.getpEmail());
        contentValues.put(DOCTOR, channel.getdName());
        contentValues.put(SPECIALIZATION, channel.getSep());

        long result = sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        if(result == -1) {

            return false;
        }
        else {

            return true;
        }
    }

}
