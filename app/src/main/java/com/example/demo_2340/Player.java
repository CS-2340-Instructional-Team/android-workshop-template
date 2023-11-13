package com.example.demo_2340;

import com.example.demo_2340.CollisionObserver.CollisionObserver;
import com.example.demo_2340.Player_Movement.MovementStrategyPattern;

public class Player implements CollisionObserver {
    private static Player instance = null;
    private MovementStrategyPattern movementStrategy;
    private int xPosition;
    private int yPosition;
    private int health;  // Added health variable

    private Player() {
        // Initialize default position and health
        this.xPosition = 0;
        this.yPosition = 0;
        this.health = 100; // Set initial health value
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
    @Override
    public void onCollisionDetected(int damage) {
        // Handle collision
        // For simplicity, let's assume each collision deducts 10 health point

        // Deduct health
        health -= damage;

        // Check if player has run out of health
        if (health <= 0) {
            // Perform actions when the player is out of health (e.g., end the game)
            endGame();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
    }
    private void endGame() {

    }
}
