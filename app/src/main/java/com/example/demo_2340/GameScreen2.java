package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen2 extends AppCompatActivity {

    private Player player;
    private Handler handler = new Handler();
    private boolean moveButtonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen2);

        Button nextButton = findViewById(R.id.nextButton);

        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("Score", ScoreTimer.getInterval());

        // Set the difficulty level in the player_info view
        TextView gameDifficultyTextView = findViewById(R.id.gameDifficultyTextView);
        gameDifficultyTextView.setText("Difficulty: " + difficulty);
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(playerName);
        TextView livescoreTextView = findViewById(R.id.livescoreTextView);
        playerNameTextView.setText("Score: " + liveScore);

        player = Player.getInstance();

        // Center the player at the start of the game
        ImageView playerImageView = findViewById(R.id.playerImageView);
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        int initialX = (screenWidth - playerImageView.getWidth()) / 2;
        int initialY = (screenHeight - playerImageView.getHeight()) / 2;
        player.setxPosition(initialX);
        player.setyPosition(initialY);
        playerImageView.setX(initialX);
        playerImageView.setY(initialY);

        // Set listeners for dpad buttons
        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        buttonUp.setOnTouchListener((v, event) -> handleTouch(event, 0, -10));
        buttonDown.setOnTouchListener((v, event) -> handleTouch(event, 0, 10));
        buttonLeft.setOnTouchListener((v, event) -> handleTouch(event, -10, 0));
        buttonRight.setOnTouchListener((v, event) -> handleTouch(event, 10, 0));
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
                intent.putExtra("difficulty", difficulty);
                intent.putExtra("playerName", playerName);
                intent.putExtra("livescore", liveScore);
                startActivity(intent);
            }
        });
    }

    private boolean handleTouch(MotionEvent event, int deltaX, int deltaY) {
        ImageView playerImageView = findViewById(R.id.playerImageView);
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moveButtonPressed = true;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (moveButtonPressed) {
                            movePlayer(deltaX, deltaY);
                            handler.postDelayed(this, 100); // Adjust the delay as needed
                        }
                    }
                }, 100); // Adjust the initial delay as needed
                break;
            case MotionEvent.ACTION_UP:
                moveButtonPressed = false;
                break;
        }
        return true;
    }

    private void movePlayer(int deltaX, int deltaY) {
        ImageView playerImageView = findViewById(R.id.playerImageView);

        int newX = player.getxPosition() + deltaX;
        int newY = player.getyPosition() + deltaY;

        // Adjust boundaries to prevent moving outside the screen
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        if (newX >= 0 && newX <= rootView.getWidth() - playerImageView.getWidth()) {
            player.setxPosition(newX);
            playerImageView.setX(newX);
        }

        if (newY >= 0 && newY <= rootView.getHeight() - playerImageView.getHeight()) {
            player.setyPosition(newY);
            playerImageView.setY(newY);
        }

        // Force the view to redraw to reflect the updated position
        rootView.invalidate();
    }
}