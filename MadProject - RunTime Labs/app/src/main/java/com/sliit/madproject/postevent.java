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
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class postevent extends AppCompatActivity {

    Button add,view;
    EditText date,list,event,task,remark,todo;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postevent);

        date = (EditText) findViewById(R.id.txtDate);
        todo = (EditText) findViewById(R.id.txtTodolist);
        list = (EditText) findViewById(R.id.txtList);
        event = (EditText) findViewById(R.id.txtEvent);
        task = (EditText) findViewById(R.id.txtTask);
        remark = (EditText) findViewById(R.id.txtRemark);
        add = (Button) findViewById(R.id.addPost);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vali()){

                    HashMap<String,Object> map= new HashMap<>();
                    map.put("todolist",todo.getText().toString());
                    map.put("date",date.getText().toString());
                    map.put("list",list.getText().toString());
                    map.put("event",event.getText().toString());
                    map.put("task",task.getText().toString());
                    map.put("remark",remark.getText().toString());

                    FirebaseDatabase.getInstance().getReference().child("post_event").push().setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            date.setText("");
                            todo.setText("");
                            list.setText("");
                            event.setText("");
                            task.setText("");
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

        view = findViewById(R.id.btnViewPost);

        view.setOnClickListener(view -> {
            Intent intent = new Intent(postevent.this, view_posts.class);
            startActivity(intent);

        });

        //Initialize And Assign Variable

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.postevent);

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
                        startActivity(new Intent(getApplicationContext()
                                , marketingplan.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.body:
                        startActivity(new Intent(getApplicationContext()
                                , Ticketing.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.postevent:
                        return true;

                }
                return false;
            }
        });
    }

    private boolean vali(){

        if(todo.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"To Do List Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(list.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"List Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(date.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Date Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(event.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"event Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(task.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"task Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        if(remark.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"remark Required!",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}