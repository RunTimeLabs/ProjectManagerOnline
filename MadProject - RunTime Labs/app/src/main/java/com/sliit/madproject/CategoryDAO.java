package com.sliit.madproject;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CategoryDAO {
    private DatabaseReference databaseReference;

    public CategoryDAO(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(Category.class.getSimpleName());
    }

    public Task<Void> add(Category category){

        return databaseReference.push().setValue(category);
    }
}
