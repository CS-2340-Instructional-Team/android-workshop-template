package com.example.demo_2340.Enemies_Implementation;

import com.example.demo_2340.CollisionObserver.CollisionObserver;

public class Heavy2 implements Enemies, CollisionObserver {
    private String type;
    private double initialXPosition;
    private double initialYPosition;
    private double xPosition;
    private double yPosition;

    public Heavy2() {
        type = "Heavy";
        this.initialXPosition = 0;
        this.initialYPosition = 0;
        this.xPosition = initialXPosition;
        this.yPosition = initialYPosition;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double move() {
        // Always move downward by a fixed amount
        double downwardMovement = 5.0;

        yPosition = initialYPosition + downwardMovement;

        return yPosition;
    }

    @Override
    public double getxPosition() {
        return xPosition;
    }

    @Override
    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    @Override
    public double getyPosition() {
        return yPosition;
    }

    @Override
    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public double getDamage() {
        return 5;
    }

    @Override
    public void onCollisionDetected(int damage) {
        // Handle collision
    }

    public void setInitialPosition(double initialX, double initialY) {
        this.initialXPosition = initialX;
        this.initialYPosition = initialY;
        this.xPosition = initialX;
        this.yPosition = initialY;
    }
}
