package com.badorek.luemon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void addLutemon(View view) {
        EditText lutemonName = findViewById(R.id.editTextName);

        RadioGroup rgLutemonColor = findViewById(R.id.rgLutemonColor);

        switch (rgLutemonColor.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                Storage.getInstance().addLutemon(new Lutemon(lutemonName.getText().toString(), "Valkoinen", 5, 4, 20, 20, 0, 0, 0, 0));
                break;

            case R.id.rbBlack:
                Storage.getInstance().addLutemon(new Lutemon(lutemonName.getText().toString(), "Musta", 9, 0, 16, 16, 0, 0, 0, 0));
                break;

            case R.id.rbPink:
                Storage.getInstance().addLutemon(new Lutemon(lutemonName.getText().toString(), "Pinkki", 7, 2, 18, 18, 0, 0, 0, 0));
                break;

            case R.id.rbGreen:
                Storage.getInstance().addLutemon(new Lutemon(lutemonName.getText().toString(), "Vihreä", 6, 3, 19, 19, 0, 0, 0, 0));
                break;

            case R.id.rbOrange:
                Storage.getInstance().addLutemon(new Lutemon(lutemonName.getText().toString(), "Oranssi", 8, 1, 17, 17, 0, 0, 0, 0));
                break;

        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}