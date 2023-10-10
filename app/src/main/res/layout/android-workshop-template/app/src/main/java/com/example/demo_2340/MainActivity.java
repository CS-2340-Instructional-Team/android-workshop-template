package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen3);
        Button startBtn = findViewById(R.id.nextButton);

        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
            double difficulty = 1;

            switch (difficultyRadioGroup.getCheckedRadioButtonId()) {
                case R.id.radioEasy:
                    difficulty = 0.5;
                    break;
                case R.id.radioMedium:
                    difficulty = 0.75;
                    break;
                case R.id.radioHard:
                    difficulty = 1;
                    break;
                default:
                    difficulty = 0.5;
                    break;
            }

            game.putExtra("difficulty", difficulty);
            startActivity(game);
            finish();
        });
    }
}