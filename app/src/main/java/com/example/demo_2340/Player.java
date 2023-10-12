package com.example.demo_2340;

public class Player {
    private static int score;
    private String name;

    private static Player p1;

    private Player(){
        score = 1000;
        name = "George P. Burdelle";
    }
    public Player (String name) {
        this.name = name;
        score = 1000;
    }
    public static Player getPlayer() {
        if(p1 == null) {
            p1 = new Player();
        }
        return p1;
    }
    public static void updateScore(int score) {
        score = score;
    }
    public static int getScore(){
        return score;
    }
}
