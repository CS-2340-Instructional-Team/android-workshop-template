package com.example.demo_2340.Enemies_Implementation;

import com.example.demo_2340.CollisionObserver.CollisionObserver;

public class Sprite implements Enemies, CollisionObserver {
    private String type;
    private double initialXPosition;
    private double initialYPosition;
    private double xPosition;
    private double yPosition;

    public Sprite() {
        type = "Sprite";
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
        // Always move to the right by a fixed amount
        double rightwardMovement = 15.0;

        yPosition += rightwardMovement;

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
        return 2;
    }


    public void setInitialPosition(double initialX, double initialY) {
        this.initialXPosition = initialX;
        this.initialYPosition = initialY;
        this.xPosition = initialX;
        this.yPosition = initialY;
    }

    @Override
    public void onCollisionDetected(int damage) {

    }
}
