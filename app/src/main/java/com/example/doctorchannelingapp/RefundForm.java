package com.example.doctorchannelingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RefundForm extends AppCompatActivity {

    EditText pName, date, repNo, amount;
    Button con_refund, can_refund;
    Context context;
    PaymentDB paymentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_form);

        pName = findViewById(R.id.Enter_refundPatient);
        date = findViewById(R.id.et_refundDate);
        repNo = findViewById(R.id.Enter_refundReceipt);
        amount = findViewById(R.id.Enter_refundAmount);
        con_refund = findViewById(R.id.Confirm_button);
        can_refund = findViewById(R.id.refund_cancelButton);
        context = this;
        paymentDB = new PaymentDB(context);

        con_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = pName.getText().toString();
                String dat = date.getText().toString();
                String rep = repNo.getText().toString();
                String amt = amount.getText().toString();

                Refund refund = new Refund(name, dat, rep, amt);
                paymentDB.addRefund(refund);
            }
        });

        can_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rep = repNo.getText().toString();
                paymentDB.deleteRefund(rep);
            }
        });

    }
}