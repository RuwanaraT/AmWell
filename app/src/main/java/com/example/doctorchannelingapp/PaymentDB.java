package com.example.doctorchannelingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PaymentDB extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "payment";
    private static final String TABLE_NAME = "payment";
    private static final String TABLE_NAME_NEW = "refund";

    // payment
    private static final String ID = "id";
    private static final String CARD_NO = "card_no";
    private static final String EX_YEAR = "ex_year";
    private static final String EX_MONTH = "ex_month";
    private static final String CVV = "cvv";
    private static final String AMOUNT = "amount";

    // refund
    private static final String NEW_ID = "id";
    private static final String PATIENT_NAME = "patient_name";
    private static final String DATE = "date";
    private static final String RECEIPT_NO = "receipt_no";
    private static final String REFUND_AMOUNT = "refund_amount";



    public PaymentDB(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CARD_NO + " TEXT,"
                +EX_YEAR + " TEXT,"
                +EX_MONTH+ " TEXT,"
                +CVV+ " TEXT,"
                +AMOUNT+ " TEXT" +
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);

        String TABLE_CREATE_QUERY_NEW = "CREATE TABLE "+TABLE_NAME_NEW+" " +
                "("
                +NEW_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +PATIENT_NAME + " TEXT,"
                +DATE + " TEXT,"
                +RECEIPT_NO+ " TEXT,"
                +REFUND_AMOUNT+ " TEXT" +
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY_NEW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);

        String DROP_TABLE_QUERY_NEW = "DROP TABLE IF EXISTS "+ TABLE_NAME_NEW;
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY_NEW);
        onCreate(sqLiteDatabase);

    }

    public void addPayment(Pay pay) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CARD_NO, pay.getCard_no());
        contentValues.put(EX_YEAR, pay.getEx_year());
        contentValues.put(EX_MONTH, pay.getEx_month());
        contentValues.put(CVV, pay.getCvv());
        contentValues.put(AMOUNT, pay.getAmount());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();

    }

    public void addRefund(Refund refund) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PATIENT_NAME, refund.getPatient_name());
        contentValues.put(DATE, refund.getDate());
        contentValues.put(RECEIPT_NO, refund.getReceipt_no());
        contentValues.put(REFUND_AMOUNT, refund.getRefund_amount());


        sqLiteDatabase.insert(TABLE_NAME_NEW, null, contentValues);

        sqLiteDatabase.close();

    }

    public void deleteRefund(String repNo) {

        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_NAME_NEW, "receipt_no = ?", new String[] {repNo});
        db.close();
    }
}