package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FightActivity extends AppCompatActivity {

    Storage storage = Storage.getInstance();

    ArrayList<Lutemon> selectedLutemons = storage.getSelectedLutemons();

    Lutemon lutemon1 = selectedLutemons.get(0);
    Lutemon lutemon2 = selectedLutemons.get(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        int image1 = lutemon1.getImage(lutemon1.getColor());
        ImageView imageView1 = findViewById(R.id.ivFirstLutemonFighter);
        imageView1.setImageResource(image1);

        String name1 = lutemon1.getName();
        TextView textView1 = findViewById(R.id.tvFirstFighter);
        textView1.setText(name1);

        int image2 = lutemon2.getImage(lutemon2.getColor());
        ImageView imageView2 = findViewById(R.id.ivSecondLutemonFighter);
        imageView2.setImageResource(image2);

        String name2 = lutemon2.getName();
        TextView textView2 = findViewById(R.id.tvSecondFighter);
        textView2.setText(name2);

        Button startFight = findViewById(R.id.btnStartFightLog);

        startFight.setOnClickListener(listener);

    }

    public void returnToListLutemonsAfterFigth(View view) {
        storage.removeSelectedLutemons();
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name1 = lutemon1.getName();
            String name2 = lutemon2.getName();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Boolean exit = false;
            while(exit == false) {
                if(lutemon1.getHealth() < lutemon2.getHealth()){
                    int lutemon2Health = lutemon2.getHealth();
                    lutemon2Health = lutemon2Health - lutemon1.getAttack();
                    lutemon2.setHealth(lutemon2Health);
                    if(lutemon2Health == 3) {
                        i++;
                    }
                    if(lutemon2Health <= 0) {
                        sb.append(name1 + " iskee kovaa!\n");
                        sb.append(name1 + " on Voittaja!!");
                        lutemon1.setExperience(lutemon1.getExperience() + 1);
                        if(lutemon2.getExperience() == 0) {
                            lutemon2.setHealth(lutemon2.getMaxHealth() - 1);
                        }else{
                            lutemon2.setExperience(lutemon2.getExperience() - 1);
                            lutemon2.setHealth(lutemon2.getMaxHealth() - 1);
                        }
                        lutemon1.setHealth(lutemon1.getMaxHealth());
                        lutemon1.setWins(lutemon1.getWins() + 1);
                        lutemon2.setLost(lutemon2.getLost() + 1);
                        exit = true;
                    }else{
                        if(i == 1){
                            sb.append(name1 + " löylytti " + name2 + " superiskulla\n");
                            lutemon2.setHealth(lutemon2Health - lutemon1.getAttack());
                            i++;
                        }else{
                            sb.append(name1 + " hyökkäsi " + name2 + " kimppuun\n");
                            sb.append(name2 + " selviytyi iskusta\n");
                            if(lutemon2Health > lutemon2.getDefense()){
                                lutemon2.setHealth(lutemon2Health + lutemon2.getDefense());
                            }else{
                                lutemon2.setHealth(lutemon2Health + 1);
                            }
                            }

                    }


                } else if (lutemon1.getHealth() >= lutemon2.getHealth()) {
                    int lutemon1Health = lutemon1.getHealth();
                    lutemon1Health = lutemon1Health - lutemon2.getAttack();
                    lutemon1.setHealth(lutemon1Health);
                    if(lutemon1Health == 5) {
                        i++;
                    }
                    if(lutemon1Health <= 0) {
                        sb.append(name2 + " lopettaa taistelun tyylikkäällä iskulla\n");
                        sb.append(name2 + " on Voittaja!!");
                        lutemon2.setExperience(lutemon2.getExperience() + 1);
                        if(lutemon1.getExperience() == 0) {
                            lutemon1.setHealth(lutemon1.getMaxHealth() - 1);
                        }else{
                            lutemon1.setExperience(lutemon1.getExperience() - 1);
                            lutemon1.setHealth(lutemon1.getMaxHealth() - 1);
                        }
                        lutemon2.setHealth(lutemon2.getMaxHealth());
                        lutemon2.setWins(lutemon2.getWins() + 1);
                        lutemon1.setLost(lutemon1.getLost() + 1);
                        exit = true;
                    }else{
                        if(i == 1){
                            sb.append(name2 + " löylytti " + name1 + " superiskulla\n");
                            lutemon1.setHealth(lutemon1Health - lutemon2.getAttack());
                            i++;
                        }else{
                            sb.append(name2 + " hyökkäsi " + name1 + " kimppuun\n");
                            sb.append(name1 + " puolusti tehokkaasti ja selviytyi\n");
                            if(lutemon1Health > lutemon1.getDefense()){
                                lutemon1.setHealth(lutemon1Health + lutemon1.getDefense());
                            }else{
                                lutemon1.setHealth(lutemon1Health + 1);
                            }
                        }


                    }
                }
            }
            Fragment fragment;
            fragment = new FragmentFight();
            Bundle fightData = new Bundle();
            fightData.putString("fightData", sb.toString());
            fragment.setArguments(fightData);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLog, fragment).commit();
        }
    };
}