package com.example.demo_2340;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.demo_2340.R; // Replace with the actual package name of your app
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {

    private List<LeaderboardItem> leaderboardData;

    public LeaderboardAdapter(List<LeaderboardItem> leaderboardData) {
        this.leaderboardData = leaderboardData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_item, parent, false); // Replace with your actual layout file
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeaderboardItem item = leaderboardData.get(position);

        // Bind data to the views
        holder.playerNameTextView.setText(item.getPlayerName());
        holder.scoreTextView.setText(String.valueOf(item.getScore()));
    }

    @Override
    public int getItemCount() {
        return leaderboardData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView playerNameTextView;
        public TextView scoreTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            playerNameTextView = itemView.findViewById(R.id.playerNameTextView); // Replace with the actual view IDs
            scoreTextView = itemView.findViewById(R.id.scoreTextView); // Replace with the actual view IDs
        }
    }
}
