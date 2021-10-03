package com.sliit.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class view_posts extends AppCompatActivity {

    RecyclerView recyclerView;
    Post_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_posts);


        recyclerView = (RecyclerView) findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Post_Event> options =
                new FirebaseRecyclerOptions.Builder<Post_Event>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("post_event"), Post_Event.class)
                        .build();

        adapter = new Post_Adapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                textSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                textSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void textSearch(String str){
        FirebaseRecyclerOptions<Post_Event> options =
                new FirebaseRecyclerOptions.Builder<Post_Event>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("post_event").orderByChild("date").startAt(str).endAt(str+"~"), Post_Event.class)
                        .build();

        adapter = new Post_Adapter(options);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}