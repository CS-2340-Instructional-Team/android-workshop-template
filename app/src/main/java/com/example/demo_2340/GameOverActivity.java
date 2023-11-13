package com.example.demo_2340;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameOverActivity extends AppCompatActivity {
    private RecyclerView leaderboardRecyclerView;
    private LeaderboardAdapter leaderboardAdapter;
    private List<LeaderboardItem> leaderboardData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        ScoreTimer.stop();

        Intent previousIntent = getIntent();
        String difficulty = previousIntent.getStringExtra("difficulty");
        String playerName = previousIntent.getStringExtra("playerName");
        int liveScore = previousIntent.getIntExtra("Score", ScoreTimer.getInterval());

        TextView gameDifficultyTextView = findViewById(R.id.gameDifficultyTextView);
        gameDifficultyTextView.setText("Difficulty: " + difficulty);
        TextView playerNameTextView = findViewById(R.id.playerNameTextView);
        playerNameTextView.setText(playerName);

        TextView finalScoreTextView = findViewById(R.id.finalScoreTitle);
        finalScoreTextView.setText("Final Score: " + liveScore);

        leaderboardRecyclerView = findViewById(R.id.leaderboardRecyclerView);
        leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load the existing leaderboard data
        leaderboardData = loadLeaderboardData();

        // Add the new score to the leaderboard
        addNewScore(playerName, liveScore);

        // Sort the leaderboard based on scores
        sortLeaderboard();

        // Limit the leaderboard to a certain number of entries (e.g., top 5)
        limitLeaderboard(5);

        // Get the Singleton instance of LeaderboardAdapter
        leaderboardAdapter = LeaderboardAdapter.getInstance(leaderboardData);
        leaderboardRecyclerView.setAdapter(leaderboardAdapter);
    }

    private List<LeaderboardItem> loadLeaderboardData() {
        // Replace this with your code to load the leaderboard data from a persistent source
        // For now, return an empty list.
        return new ArrayList<>();
    }

    private void saveLeaderboardData(List<LeaderboardItem> leaderboardData) {
        // Replace this with your code to save the leaderboard data to a persistent source
    }

    private void addNewScore(String playerName, int score) {
        leaderboardData.add(new LeaderboardItem(playerName, score));
    }

    private void sortLeaderboard() {
        // Sort the leaderboard in descending order based on scores
        Collections.sort(leaderboardData, (item1, item2) -> item2.getScore() - item1.getScore());
    }

    private void limitLeaderboard(int limit) {
        // Limit the leaderboard to a certain number of entries
        if (leaderboardData.size() > limit) {
            leaderboardData = leaderboardData.subList(0, limit);
        }
    }

    public void endGame(View view) {
        // Save the updated leaderboard data
        saveLeaderboardData(leaderboardData);

        Intent intent = new Intent(GameOverActivity.this, LaunchScreen.class);
        startActivity(intent);
        ScoreTimer.reset();
        finish();
    }
}
