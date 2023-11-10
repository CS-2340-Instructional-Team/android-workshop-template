package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo_2340.Player_Movement.MoveDown;
import com.example.demo_2340.Player_Movement.MoveLeft;
import com.example.demo_2340.Player_Movement.MoveRight;
import com.example.demo_2340.Player_Movement.MoveUp;
import com.example.demo_2340.Player_Movement.MovementStrategyPattern;
public class GameScreen2 extends AppCompatActivity {

    private Player player;
    private boolean moveButtonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen2);

        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("livescore", ScoreTimer.getInterval());

        // Set the difficulty level in the player_info view
        TextView gameDifficultyTextView = findViewById(R.id.gameDifficultyTextView);
        gameDifficultyTextView.setText("Difficulty: " + difficulty);
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(playerName);
        TextView livescoreTextView = findViewById(R.id.livescoreTextView);
        livescoreTextView.setText("Score: " + liveScore);

        player = Player.getInstance();

        // Center the player at the start of the game
        ImageView playerImageView = findViewById(R.id.playerImageView);
        int initialX = (getResources().getDisplayMetrics().widthPixels - playerImageView.getWidth()) / 2;
        int initialY = (getResources().getDisplayMetrics().heightPixels - playerImageView.getHeight()) / 2;
        player.setxPosition(initialX);
        player.setyPosition(initialY);
        playerImageView.setX(initialX);
        playerImageView.setY(initialY);

        // Set listeners for dpad buttons
        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        int amount = 40;
        MovementStrategyPattern up = new MoveUp();
        buttonUp.setOnTouchListener((v, event) -> handleTouch(event, 0, up.move(amount)));
        MovementStrategyPattern down = new MoveDown();
        buttonDown.setOnTouchListener((v, event) -> handleTouch(event, 0, down.move(amount)));
        MovementStrategyPattern left = new MoveLeft();
        buttonLeft.setOnTouchListener((v, event) -> handleTouch(event, left.move(amount), 0));
        MovementStrategyPattern right = new MoveRight();
        buttonRight.setOnTouchListener((v, event) -> handleTouch(event, right.move(amount), 0));

        RelativeLayout nextScreenLayout = findViewById(R.id.nextScreenLayout);
        nextScreenLayout.setOnClickListener(v -> moveToNextScreen());
    }

    private boolean handleTouch(MotionEvent event, int deltaX, int deltaY) {
        ImageView playerImageView = findViewById(R.id.playerImageView);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moveButtonPressed = true;
                movePlayer(deltaX, deltaY);
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

        // Check if the player's position intersects with the nextScreenLayout
        RelativeLayout nextScreenLayout = findViewById(R.id.nextScreenLayout);
        if (isViewOverlapping(playerImageView, nextScreenLayout)) {
            moveToNextScreen();
        }

        // Force the view to redraw to reflect the updated position
        rootView.invalidate();
    }

    private boolean isViewOverlapping(View firstView, View secondView) {
        int[] firstPosition = new int[2];
        int[] secondPosition = new int[2];

        firstView.getLocationOnScreen(firstPosition);
        secondView.getLocationOnScreen(secondPosition);

        int firstX = firstPosition[0];
        int firstY = firstPosition[1];
        int secondX = secondPosition[0];
        int secondY = secondPosition[1];

        return firstX < secondX + secondView.getWidth() &&
                firstX + firstView.getWidth() > secondX &&
                firstY < secondY + secondView.getHeight() &&
                firstY + firstView.getHeight() > secondY;
    }

    private void moveToNextScreen() {
        // Retrieve necessary data
        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("livescore", ScoreTimer.getInterval());

        // Start the next activity
        Intent intent = new Intent(GameScreen2.this, GameScreen3.class);
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("playerName", playerName);
        intent.putExtra("livescore", liveScore);
        startActivity(intent);
    }
}
