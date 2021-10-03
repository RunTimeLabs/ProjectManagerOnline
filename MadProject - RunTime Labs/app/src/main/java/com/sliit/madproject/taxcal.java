package com.sliit.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class taxcal extends AppCompatActivity {

    TextView balance,taxvalue;
    EditText totincome,tax;
    Button calc;
    String taxva,bava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxcal);

        balance=findViewById(R.id.balance);
        taxvalue=findViewById(R.id.taxvalue);
        totincome=findViewById(R.id.totincome);
        tax=findViewById(R.id.tax);
        calc=findViewById(R.id.calc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taxcal.this.calTax();
            }
        });
    }
    public void calTax(){
        String t = tax.getText().toString();
        String b = totincome.getText().toString();

        float taxv=Float.parseFloat(t);
        float bv = Float.parseFloat(b);

        float taxresult = (bv*taxv/100);
        float totresult = (bv-taxresult);

        taxva="LKR: "+taxresult;
        bava="LKR: "+totresult;

        balance.setText(bava);
        taxvalue.setText(taxva);


    }
}