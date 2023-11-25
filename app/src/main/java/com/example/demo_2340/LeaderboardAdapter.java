package com.example.demo_2340;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {
    private static LeaderboardAdapter instance;
    private List<LeaderboardItem> leaderboardData;
    private LeaderboardAdapter(List<LeaderboardItem> leaderboardData) {
        this.leaderboardData = leaderboardData;
        this.leaderboardData.add(new LeaderboardItem("Grant", 400));
        this.leaderboardData.add(new LeaderboardItem("Rohan", 350));
        this.leaderboardData.add(new LeaderboardItem("Bodan", 250));
        this.leaderboardData.add(new LeaderboardItem("Ary", 150));
    }


    public static LeaderboardAdapter getInstance(List<LeaderboardItem> leaderboardData) {
        if (instance == null) {
            instance = new LeaderboardAdapter(leaderboardData);
        }
        return instance;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_item,
                        parent, false); // Replace with your actual layout file
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeaderboardItem item = leaderboardData.get(position);

        // Bind data to the views
        holder.playerNameTextView.setText(item.getPlayerName());
        holder.scoreTextView.setText(String.valueOf(item.getScore()));
        //holder.scoreDateView.setText(String.valueOf(item.getDate()));
    }

    @Override
    public int getItemCount() {
        return leaderboardData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView playerNameTextView;
        private TextView scoreTextView;

        //public TextView scoreDateView;

        public ViewHolder(View itemView) {
            super(itemView);
            playerNameTextView = itemView.findViewById(R.id.playerNameTextView);
            // Replace with the actual view IDs
            scoreTextView = itemView.findViewById(R.id.scoreTextView);
            // Replace with the actual view IDs
            //scoreDateView = itemView.findViewById(R.id.scoreDateView);
        }
    }
}
