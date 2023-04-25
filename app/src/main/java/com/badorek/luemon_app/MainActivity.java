package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemon.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view) {
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void saveToMemory(View view){
        Storage.getInstance().saveLutemons(context);
    }

    public void loadFromMemory(View view){
        Storage.getInstance().loadLutemons(context);
    }
}