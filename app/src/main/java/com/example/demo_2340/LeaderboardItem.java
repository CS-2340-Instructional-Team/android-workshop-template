package com.example.demo_2340;

public class LeaderboardItem {
    private String playerName;
    private int score;

    //private final String date;
    public LeaderboardItem(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
        //date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //public String getDate() {
    //    return date;
    //}
}

