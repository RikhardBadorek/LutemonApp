package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {

    Storage storage = Storage.getInstance();

    ArrayList<Lutemon> selectedLutemons = storage.getSelectedLutemons();

    Lutemon lutemon1 = selectedLutemons.get(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        int image1 = lutemon1.getImage(lutemon1.getColor());
        ImageView imageView1 = findViewById(R.id.ivLutemonStats);
        imageView1.setImageResource(image1);

        String name1 = lutemon1.getName();
        TextView textView1 = findViewById(R.id.tvStatsName);
        textView1.setText(name1);

        int experience = lutemon1.getExperience();
        TextView textView2 = findViewById(R.id.tvStatsExperience);
        textView2.setText("Kokemus: " + experience);

        int wins = lutemon1.getWins();
        TextView textView3 = findViewById(R.id.tvStatsWins);
        textView3.setText("Voitot: " + wins);

        int lost = lutemon1.getLost();
        TextView textView4 = findViewById(R.id.tvStatsLost);
        textView4.setText("Häviöt: " + lost);

        int trainingDays = lutemon1.getTrainingDays();
        TextView textView5 = findViewById(R.id.tvStatsTrainingDays);
        textView5.setText("Koulutus päivät: " + trainingDays);
    }
}