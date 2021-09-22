package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE = "amWell";
    private static final String TABLE_NAME = "patient";

    // column names
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String GENDER = "gender";
    private static final String NIC = "nic";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String PASSWORD = "password";
    private static final String RE_PASSWORD = "re_password";


    public DBManager(@Nullable Context context) { super(context, DATABASE, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
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

    public void PatientRegistration(Patient patient) {

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

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }
}
