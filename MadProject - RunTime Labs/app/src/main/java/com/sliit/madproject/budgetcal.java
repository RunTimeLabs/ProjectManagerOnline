package com.sliit.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class budgetcal extends AppCompatActivity {
    EditText daysleft,budget;
    Button calcbudget;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgetcal);

        daysleft=findViewById(R.id.daysleft);
        budget=findViewById(R.id.budget);
        calcbudget=findViewById(R.id.clacbudget);
        result=findViewById(R.id.result);

        calcbudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                budgetcal.this.calcBud();
            }
        });
    }

    public void calcBud(){
        String d=daysleft.getText().toString();
        String bu = budget.getText().toString();

        float dv=Float.parseFloat(d);
        float buv=Float.parseFloat(bu);

        float re= buv/dv;
        String x="Target Budget for a Day: "+re;

        result.setText(x);
    }
}