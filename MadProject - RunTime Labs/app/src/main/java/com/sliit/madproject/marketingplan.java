package com.sliit.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class marketingplan extends AppCompatActivity {
    FloatingActionButton fview;

    Button add,view;
    EditText date,plan,title,event,details,remark;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketingplan);


        date = (EditText) findViewById(R.id.txtDateM);
        plan = (EditText) findViewById(R.id.txtPlanM);
        title = (EditText) findViewById(R.id.txtTitleM);
        event = (EditText) findViewById(R.id.txtEventM);
        details = (EditText) findViewById(R.id.txtDetailM);
        remark = (EditText) findViewById(R.id.txtRemarkM);
        add = (Button) findViewById(R.id.addPreM);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vali()){

                    HashMap<String,Object> map= new HashMap<>();
                    map.put("plan",plan.getText().toString());
                    map.put("date",date.getText().toString());
                    map.put("title",title.getText().toString());
                    map.put("event",event.getText().toString());
                    map.put("details",details.getText().toString());
                    map.put("remark",remark.getText().toString());

                    FirebaseDatabase.getInstance().getReference().child("pre_event").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            date.setText("");
                            title.setText("");
                            event.setText("");
                            plan.setText("");
                            details.setText("");
                            remark.setText("");
                            Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Inserted Unsuccessfully",Toast.LENGTH_LONG).show();
                        }
                    });


                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,2021,10,01);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day_of_month) {
                month = month+1;
                String dates = year+"-"+month+"-"+day_of_month;
                date.setText(dates);
            }
        };

        view = findViewById(R.id.btnViewpPre);

        view.setOnClickListener(view -> {
            Intent intent = new Intent(marketingplan.this, view_pre.class);
            startActivity(intent);

        });

        //Initialize And Assign Variable

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.habit);


        //Perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.habit:
                        return true;

                    case R.id.body:
                        startActivity(new Intent(getApplicationContext()
                                , Ticketing.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.postevent:
                        startActivity(new Intent(getApplicationContext()
                                , postevent.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
        fview = findViewById(R.id.fview);

        fview.setOnClickListener(view -> {
            Intent intent = new Intent(marketingplan.this, viewPlans.class);
            startActivity(intent);

        });
    }


    private boolean vali(){

        if(plan.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Plan Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(details.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Details Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(date.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Date Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(event.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Event Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(title.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Title Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(remark.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"remark Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}