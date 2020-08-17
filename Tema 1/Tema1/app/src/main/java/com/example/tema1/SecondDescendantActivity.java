package com.example.tema1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;

public class SecondDescendantActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyListAdapter mAdapter;

    private static final LinkedList<String> ITEMS = new LinkedList<>(Arrays.asList("1","2",
            "3","4", "5", "6", "7", "8", "9", "10"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_descendant);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        if(ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new MyListAdapter(this, ITEMS);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void switchToActivityOne(View view) {
        Intent i = new Intent(this, FirstDescendantActivity.class);
        startActivity(i);
    }

    public void displayToast(View view) {
        Toast.makeText(this, "Click!",
                Toast.LENGTH_SHORT).show();
    }
}