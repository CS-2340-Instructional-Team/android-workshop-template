package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startBtn = findViewById(R.id.startButton);

        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            RadioGroup characterRadioGroup = findViewById(R.id.characterRadioGroup);
            double character = 1;

            switch (characterRadioGroup.getCheckedRadioButtonId()) {
                case R.id.zeusOption:
                    character = 0.5;
                    break;
                case R.id.poseidonOption:
                    character = 0.75;
                    break;
                case R.id.hadesOption:
                    character = 1;
                    break;
                default:
                    character = 0.5;
                    break;
            }
            Intent game = new Intent(MainActivity.this, GameActivity.class);
            game.putExtra("Character", character);
            startActivity(game);
            finish();
        });
    }
}