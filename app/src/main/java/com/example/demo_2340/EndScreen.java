package com.example.demo_2340;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EndScreen extends AppCompatActivity {

    private RecyclerView leaderboardRecyclerView;
    private LeaderboardAdapter leaderboardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        // Initialize the RecyclerView
        leaderboardRecyclerView = findViewById(R.id.leaderboardRecyclerView);
        leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create sample leaderboard data (you should replace this with your actual data)
        List<LeaderboardItem> leaderboardData = createSampleLeaderboardData();

        // Get the Singleton instance of LeaderboardAdapter
        leaderboardAdapter = LeaderboardAdapter.getInstance(leaderboardData);
        leaderboardRecyclerView.setAdapter(leaderboardAdapter);
    }

    // Helper method to create sample leaderboard data
    private List<LeaderboardItem> createSampleLeaderboardData() {
        List<LeaderboardItem> leaderboardData = new ArrayList<>();

        // Add sample leaderboard items
        leaderboardData.add(new LeaderboardItem("Grant", 1000));
        leaderboardData.add(new LeaderboardItem("Rohan", 850));
        leaderboardData.add(new LeaderboardItem("Bodan", 600));
        leaderboardData.add(new LeaderboardItem("Ary", 400));
        leaderboardData.add(new LeaderboardItem("Stephen", 100));
        // Add more items as needed

        return leaderboardData;
    }

    public void endGame(View view) {
        Intent intent = new Intent(EndScreen.this, LaunchScreen.class);
        startActivity(intent);
    }
}
