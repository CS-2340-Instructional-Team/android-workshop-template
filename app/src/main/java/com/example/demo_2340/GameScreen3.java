package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen3);

        Button nextButton = findViewById(R.id.nextButton);

        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");

        // Set the difficulty level in the player_info view
        TextView gameDifficultyTextView = findViewById(R.id.gameDifficultyTextView);
        gameDifficultyTextView.setText("Difficulty: " + difficulty);
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(playerName);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameScreen3.this, EndScreen.class);
                intent.putExtra("difficulty", difficulty);
                intent.putExtra("playerName", playerName);
                startActivity(intent);
            }
        });
    }
}