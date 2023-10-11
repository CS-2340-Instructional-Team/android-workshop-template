package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;

public class GameScreen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen1);

        Button nextButton = findViewById(R.id.nextButton);

        // Retrieve the selected difficulty from the previous activity's Intent
        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("Score", scoreTimer.getInterval());

        // Set the difficulty level in the player_info view
        TextView gameDifficultyTextView = findViewById(R.id.gameDifficultyTextView);
        gameDifficultyTextView.setText("Difficulty: " + difficulty);
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(playerName);
        TextView livescoreTextView = findViewById(R.id.livescore);
        playerNameTextView.setText("score: " + liveScore);


        // Assuming you have a playerName available, you can set it as well
        // TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        // playerNameTextView.setText("Player Name: " + playerName);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameScreen1.this, GameScreen2.class);
                intent.putExtra("difficulty", difficulty);
                intent.putExtra("playerName", playerName);
                intent.putExtra("livescore", liveScore);
                startActivity(intent);
            }
        });
    }
}
