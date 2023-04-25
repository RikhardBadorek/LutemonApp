package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListLutemonsActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvLutemonList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), storage.getLutemons()));

        context = ListLutemonsActivity.this;

    }
    public void switchToTrainLutemons(View view) {
        int i = storage.getSelectedLutemonsCount();
        if(i == 1){
            Intent intent = new Intent(this, trainLutemonActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(context, "Valitse juurikin yksi lutemoni koulutukseen kerrallaan", Toast.LENGTH_LONG).show();
            storage.removeSelectedLutemons();
            Intent intent = new Intent(this, ListLutemonsActivity.class);
            startActivity(intent);
        }

    }

    public void switchToLutemonStats(View view) {
        int i = storage.getSelectedLutemonsCount();
        if(i == 1){
            Intent intent = new Intent(this, StatsActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(context, "Valitse juurikin yksi lutemoni tilastoihin kerrallaan", Toast.LENGTH_LONG).show();
            storage.removeSelectedLutemons();
            Intent intent = new Intent(this, ListLutemonsActivity.class);
            startActivity(intent);
        }

    }

    public void switchToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void switchToFightLutemons(View view) {
        int i = storage.getSelectedLutemonsCount();
        if(i == 2){
            Intent intent = new Intent(this, FightActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(context, "Valitse juurikin kaksi lutemonia taisteluun kerrallaan", Toast.LENGTH_LONG).show();
            storage.removeSelectedLutemons();
            Intent intent = new Intent(this, ListLutemonsActivity.class);
            startActivity(intent);

        }
    }

}