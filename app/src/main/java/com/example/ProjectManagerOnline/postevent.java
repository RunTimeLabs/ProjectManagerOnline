package com.example.ProjectManagerOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class postevent extends AppCompatActivity {

    FloatingActionButton fb;
    EditText name, work, description, purl;
    Button submit, viewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postevent);

        name = (EditText)findViewById(R.id.add_name);
        description = (EditText)findViewById(R.id.add_description);
        work = (EditText)findViewById(R.id.add_work);
        purl = (EditText)findViewById(R.id.add_purl);


        submit = (Button)findViewById(R.id.add_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });


        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.meal);

        fb = (FloatingActionButton)findViewById(R.id.fadd);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), postevent.class));
            }
        });

        //Perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.habit:
                        startActivity(new Intent(getApplicationContext()
                                ,habit.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.body:
                        startActivity(new Intent(getApplicationContext()
                                , Ticketing.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.meal:
                        return true;

                }
                return false;
            }
        });


        viewbtn = findViewById(R.id.viewbtn);

        viewbtn.setOnClickListener(view -> {
            Intent intent = new Intent(postevent.this, ViewWork.class);
            startActivity(intent);

        });
    }

    private void processinsert()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("work", work.getText().toString());
        map.put("description", description.getText().toString());
        map.put("purl", purl.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void avoid) {
                        name.setText("");
                        work.setText("");
                        description.setText("");
                        purl.setText("");
                        Toast.makeText(getApplicationContext(), "Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Could not insert",Toast.LENGTH_LONG).show();
                    }
                });
    }
}