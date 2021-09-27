package com.example.ProjectManagerOnline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class body extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        final EditText addCategory = (findViewById(R.id.etAddCategory));
        Button btnAdd = (findViewById(R.id.btn_add_cat));
        CategoryDAO categoryDAO = new CategoryDAO();

        btnAdd.setOnClickListener(v->{
            Category category = new Category(addCategory.getText().toString());
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
                                ,habit.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.body:
                        return true;

                    case R.id.meal:
                        startActivity(new Intent(getApplicationContext()
                                ,meal.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

    }
}