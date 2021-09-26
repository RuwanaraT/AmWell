package com.example.doctorchannelingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PaymentDB extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "payment";
    private static final String TABLE_NAME = "payment";

    private static final String RECEIPT_NO = "receipt_no";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String IS_DATE = "is_date";
    private static final String AMOUNT = "amount";
    private static final String CARD_NO = "card_no";
    private static final String EX_YEAR = "ex_year";
    private static final String EX_MONTH = "ex_month";
    private static final String CVV = "cvv";

    public PaymentDB(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +RECEIPT_NO+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME + " TEXT,"
                +EMAIL + " TEXT,"
                +IS_DATE+ " TEXT,"
                +AMOUNT+ " TEXT,"
                +CARD_NO+ " TEXT,"
                +EX_YEAR+ " TEXT,"
                +EX_MONTH+ " TEXT,"
                +CVV+ " TEXT" +
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        onCreate(sqLiteDatabase);

    }
}