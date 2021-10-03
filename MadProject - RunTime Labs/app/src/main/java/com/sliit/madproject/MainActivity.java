package com.sliit.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button ticketCal,taxcal,bcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize And Assign Variable

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext()
                                , postevent.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

        //ticket cal
        ticketCal = findViewById(R.id.ticketCalc);
        ticketCal.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ticketCal.class);
            startActivity(intent);

        });

        //tax cal
        taxcal = findViewById(R.id.taxcalc);
        taxcal.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, taxcal.class);
            startActivity(intent);

        });

        //budget cal
        bcal = findViewById(R.id.bcal);
        bcal.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, budgetcal.class);
            startActivity(intent);

        });

    }
}