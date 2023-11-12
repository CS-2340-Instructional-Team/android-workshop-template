package com.example.demo_2340;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_2340.Enemies_Implementation.Enemies;
import com.example.demo_2340.Enemies_Implementation.Heavy1;
import com.example.demo_2340.Enemies_Implementation.Sprite;
import com.example.demo_2340.Player_Movement.MoveDown;
import com.example.demo_2340.Player_Movement.MoveLeft;
import com.example.demo_2340.Player_Movement.MoveRight;
import com.example.demo_2340.Player_Movement.MoveUp;
import com.example.demo_2340.Player_Movement.MovementStrategyPattern;

public class GameScreen1 extends AppCompatActivity {

    private Player player;
    private Enemies spriteEnemy; // Update the type to Enemies
    private Enemies heavyEnemy;
    private boolean moveButtonPressed = false;

    private final Handler clockHandler = new Handler(Looper.myLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen1);
        ScoreTimer.setCurrentGameScreenInstance(this);
        ScoreTimer.start();

        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("livescore", ScoreTimer.getInterval());

        TextView gameDifficultyTextView = findViewById(R.id.gameDifficultyTextView);
        gameDifficultyTextView.setText("Difficulty: " + difficulty);
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(playerName);
        TextView livescoreTextView = findViewById(R.id.livescoreTextView);
        livescoreTextView.setText("Score: " + liveScore);

        spriteEnemy = new Sprite(); // Instantiate Sprite instead of Enemy
        heavyEnemy = new Heavy1();

        player = Player.getInstance();


        ImageView playerImageView = findViewById(R.id.playerImageView);
        int initialX = (getResources().getDisplayMetrics().widthPixels - playerImageView.getWidth()) / 2;
        int initialY = (getResources().getDisplayMetrics().heightPixels - playerImageView.getHeight()) / 2;
        player.setxPosition(initialX);
        player.setyPosition(initialY);
        playerImageView.setX(initialX);
        playerImageView.setY(initialY);


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

        moveEnemySprite();
        moveEnemyHeavy();
        startClockLoop();
    }

    private void startClockLoop() {
        // Define the task to be executed by the clock loop
        Runnable clockRunnable = new Runnable() {
            @Override
            public void run() {
                // Update the score
                updateScore();

                // Move enemies
                moveEnemySprite();
                moveEnemyHeavy();

                // Schedule the next execution of the clock loop
                clockHandler.postDelayed(this, 1000); // Adjust the delay as needed
            }
        };

        // Start the clock loop
        clockHandler.post(clockRunnable);
    }

    private void updateScore() {
        // Update the score TextView
        TextView livescoreTextView = findViewById(R.id.livescoreTextView);
        livescoreTextView.setText("Score: " + ScoreTimer.getInterval());
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

        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        if (newX >= 0 && newX <= rootView.getWidth() - playerImageView.getWidth()) {
            player.setxPosition(newX);
            playerImageView.setX((float)newX);
        }

        if (newY >= 0 && newY <= rootView.getHeight() - playerImageView.getHeight()) {
            player.setyPosition(newY);
            playerImageView.setY((float)newY);
        }

        RelativeLayout nextScreenLayout = findViewById(R.id.nextScreenLayout);
        if (isViewOverlapping(playerImageView, nextScreenLayout)) {
            moveToNextScreen();
        }

        rootView.invalidate();
    }
    private void moveEnemySprite() {
        ImageView playerImageView = findViewById(R.id.enemyImageView1);
        double newX = spriteEnemy.move();
        double newY = spriteEnemy.move();

        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        if (newX >= 0 && newX <= rootView.getWidth() - playerImageView.getWidth()) {
            spriteEnemy.setxPosition(newX);
            playerImageView.setX((float) newX);
        }

        if (newY >= 0 && newY <= rootView.getHeight() - playerImageView.getHeight()) {
            spriteEnemy.setyPosition(newY);
            playerImageView.setY((float) newY);
        }
        // ADD COLLISION CODE HERE!!!!!!!
    }

    private void moveEnemyHeavy() {
        ImageView playerImageView = findViewById(R.id.enemyImageView2);
        double newX = heavyEnemy.move();
        double newY = heavyEnemy.move();

        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        if (newX >= 0 && newX <= rootView.getWidth() - playerImageView.getWidth()) {
            heavyEnemy.setxPosition(newX);
            playerImageView.setX((float) newX);
        }

        if (newY >= 0 && newY <= rootView.getHeight() - playerImageView.getHeight()) {
            heavyEnemy.setyPosition(newY);
            playerImageView.setY((float) newY);
        }
        // ADD COLLISION CODE HERE!!!!!!!
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
        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("livescore", ScoreTimer.getInterval());

        Intent intent = new Intent(GameScreen1.this, GameScreen2.class);
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("playerName", playerName);
        intent.putExtra("livescore", liveScore);
        startActivity(intent);
    }
}
