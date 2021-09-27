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

public class meal extends AppCompatActivity {

    FloatingActionButton fb;
    EditText name, work, description, purl;
    Button submit, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        name = (EditText)findViewById(R.id.add_name);
        description = (EditText)findViewById(R.id.add_description);
        work = (EditText)findViewById(R.id.add_work);
        purl = (EditText)findViewById(R.id.add_purl);

        back = (Button)findViewById(R.id.add_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

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
                startActivity(new Intent(getApplicationContext(),meal.class));
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
                                ,body.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.meal:
                        return true;

                    case R.id.RecyclerView:
                        startActivity(new Intent(getApplicationContext()
                                ,RecyclerView.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
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