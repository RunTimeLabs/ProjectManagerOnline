package com.sliit.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Ticketing extends AppCompatActivity {

    Button btnViewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketing);

        final EditText addCategory = (findViewById(R.id.etAddCategory));
        final EditText addPrice = (findViewById(R.id.etPrice));
        final EditText addCount = (findViewById(R.id.etTicketCont));
        Button btnAdd = (findViewById(R.id.btn_add_cat));
        CategoryDAO categoryDAO = new CategoryDAO();

        btnAdd.setOnClickListener(v->{
            Category category = new Category(addCategory.getText().toString(), addPrice.getText().toString(), addCount.getText().toString());
            categoryDAO.add(category).addOnSuccessListener(success->
            {
                Toast.makeText(this, "Category Added Successfully!", Toast.LENGTH_LONG).show();
            }).addOnFailureListener(error->{
                Toast.makeText(this, "Cannot Add the Category", Toast.LENGTH_LONG).show();
            });
        });

        //Initialize And Assign Variable

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.body);

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
                                , marketingplan.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.body:
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

        btnViewall = findViewById(R.id.btn_viewall_activity);

        btnViewall.setOnClickListener(view -> {
            Intent intent = new Intent(Ticketing.this, viewEditDeleteTicket.class);
            startActivity(intent);

        });

    }
}