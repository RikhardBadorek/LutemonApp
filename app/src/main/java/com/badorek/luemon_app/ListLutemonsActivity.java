package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListLutemonsActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvLutemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getLutemons()));

    }
    public void switchToTrainLutemons(View view) {
        Intent intent = new Intent(this, trainLutemonActivity.class);
        /*Bundle b = new Bundle();
        b.putInt("lutemonPosition", );*/
        startActivity(intent);
    }

}