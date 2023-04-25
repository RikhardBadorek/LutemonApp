package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class trainLutemonActivity extends AppCompatActivity {

    public trainLutemonActivity (){

    }
    Storage storage = Storage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemon);

        for(Lutemon l : storage.getSelectedLutemons()) {
            int image = l.getImage(l.getColor());
            ImageView imageView = findViewById(R.id.ivSelectedLutemon);
            imageView.setImageResource(image);
            String name = l.getName();
            TextView textView = findViewById(R.id.tvLutemonInTrainingName);
            textView.setText(name);

            l.setTrainingDays(l.getTrainingDays() + 1);
        }
    }

    public void switchToListLutemons(View view) {
        storage.removeSelectedLutemons();
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void improveHealth(View view){
        for(Lutemon l : storage.getSelectedLutemons()) {
            int maxHealth = l.getMaxHealth();
            maxHealth++;
            l.setMaxHealth(maxHealth);
        }
    }

    public void improveAttack(View view){
        for(Lutemon l : storage.getSelectedLutemons()) {
            int attack = l.getAttack();
            attack++;
            l.setAttack(attack);
        }
    }

    public void improveDefense(View view){
        for(Lutemon l : storage.getSelectedLutemons()) {
            int defense = l.getDefense();
            defense++;
            l.setDefense(defense);;
        }
    }

}