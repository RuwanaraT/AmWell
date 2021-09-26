package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Payment extends AppCompatActivity {

    EditText card_no, ex_year, ex_month, cvv, amount;
    Button c_payment, c_cancel;
    Context context;
    PaymentDB paymentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        card_no = findViewById(R.id.et_cardNo);
        ex_year = findViewById(R.id.et_crdyer);
        ex_month = findViewById(R.id.et_crdmnt);
        cvv = findViewById(R.id.et_cvv);
        amount = findViewById(R.id.et_amt);
        c_payment = findViewById(R.id.btn_payConfirm);
        context = this;
        paymentDB = new PaymentDB(context);

        c_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String card = card_no.getText().toString();
                String year = ex_year.getText().toString();
                String month = ex_month.getText().toString();
                String cvv_no = cvv.getText().toString();
                String amt = amount.getText().toString();

                Pay pay = new Pay(card, year, month, cvv_no, amt);
                paymentDB.addPayment(pay);
            }
        });
    }
}