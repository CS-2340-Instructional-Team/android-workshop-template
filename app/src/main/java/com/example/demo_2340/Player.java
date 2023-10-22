package com.example.demo_2340;

public class Player {
    private static Player instance = null;
    private int xPosition;
    private int yPosition;

    private Player() {
        // Initialize default position
        this.xPosition = 0;
        this.yPosition = 0;
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
