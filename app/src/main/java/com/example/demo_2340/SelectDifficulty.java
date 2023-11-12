package com.example.demo_2340;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectDifficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        Button startButton = findViewById(R.id.startButton);
        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        Intent previousIntent = getIntent();
        String playerName = previousIntent.getStringExtra("playerName");

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = difficultyRadioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String difficulty = selectedRadioButton.getText().toString();

                    // Create an Intent to start the target activity
                    Intent intent = new Intent(SelectDifficulty.this, GameScreen1.class);

                    // Add the selected difficulty as an extra to the Intent
                    intent.putExtra("playerName", playerName);
                    intent.putExtra("difficulty", difficulty);

                    ScoreTimer s1 = new ScoreTimer();
                    // Start the target activity
                    startActivity(intent);
                } else {
                    Toast.makeText(SelectDifficulty.this, "Please Select a Difficulty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
