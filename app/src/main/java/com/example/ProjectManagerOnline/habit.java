package com.example.ProjectManagerOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class habit extends AppCompatActivity {
    FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);



        //Initialize And Assign Variable

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.habit);

        fab=(FloatingActionButton)findViewById(R.id.fadd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , com.example.ProjectManagerOnline.MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.habit:
                        return true;

                    case R.id.body:
                        startActivity(new Intent(getApplicationContext()
                                , com.example.ProjectManagerOnline.body.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.meal:
                        startActivity(new Intent(getApplicationContext()
                                , com.example.ProjectManagerOnline.meal.class));
                        overridePendingTransition(0,0);
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
}