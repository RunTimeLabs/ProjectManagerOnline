package com.example.ProjectManagerOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class marketingplan extends AppCompatActivity {
    FloatingActionButton fview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketingplan);



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
                                , com.example.ProjectManagerOnline.MainActivity.class));
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
}