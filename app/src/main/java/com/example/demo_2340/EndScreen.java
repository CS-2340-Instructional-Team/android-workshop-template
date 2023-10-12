package com.example.demo_2340;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Collections;
import java.util.List;
//import java.util.Locale;

public class EndScreen extends AppCompatActivity {

    private RecyclerView leaderboardRecyclerView;
    private LeaderboardAdapter leaderboardAdapter;

    //String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        // Initialize the RecyclerView
        leaderboardRecyclerView = findViewById(R.id.leaderboardRecyclerView);
        leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create sample leaderboard data (you should replace this with your actual data)
        List<LeaderboardItem> leaderboardData = createSampleLeaderboardData();

        for (int i = 1; i < leaderboardData.size() - 1; i++){
            if (leaderboardData.get(i - 1).getScore() < leaderboardData.get(i - 1).getScore()) {
                leaderboardData.set(i-1, leaderboardData.get(i));
            }
        }
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
