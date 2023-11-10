package com.example.demo_2340;
import com.example.demo_2340.Player_Movement.MovementStrategyPattern;

public class Player {
    private static Player instance = null;
    private MovementStrategyPattern movementStrategy;
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

    public void setMovementStrategy(MovementStrategyPattern movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
}
