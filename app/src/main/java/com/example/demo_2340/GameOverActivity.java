package com.example.demo_2340;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GameOverActivity extends AppCompatActivity {
    private RecyclerView leaderboardRecyclerView;
    private LeaderboardAdapter leaderboardAdapter;
    private List<LeaderboardItem> leaderboardData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Handler clockHandler = new Handler(Looper.myLooper());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        ScoreTimer.stop();

        TextView finalScoreTextView = findViewById(R.id.finalScoreTitle);
        finalScoreTextView.setText("GAME OVER");
        clockHandler.removeCallbacksAndMessages(null);
    }


    public void endGame(View view) {
        // Save the updated leaderboard data

        Intent intent = new Intent(GameOverActivity.this, LaunchScreen.class);
        startActivity(intent);
        ScoreTimer.reset();
        finish();
    }
}
