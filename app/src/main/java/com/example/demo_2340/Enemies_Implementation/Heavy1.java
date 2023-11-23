package com.example.demo_2340.Enemies_Implementation;

import com.example.demo_2340.CollisionObserver.CollisionObserver;

public class Heavy1 implements Enemies, CollisionObserver {
    private String type;
    private double initialXPosition;
    private double initialYPosition;
    private double xPosition;
    private double yPosition;

    public Heavy1() {
        type = "Heavy";
        this.initialXPosition = 0;
        this.initialYPosition = 0;
        this.xPosition = initialXPosition;
        this.yPosition = initialYPosition;
    }
    private int movementMultiplier = 4;
    private double randomMultiplier = 10.0 * movementMultiplier;
    private int rightBound = 7 * movementMultiplier;
    private int leftBound = 5 * movementMultiplier;
    private int downBound = 3 * movementMultiplier;
  
    public String getType() {
        return type;
    }

    public double move() {
        double randMovementAmount = Math.random() * randomMultiplier;
        String direc = "";
        if (randMovementAmount <= randomMultiplier && randMovementAmount > rightBound) {
            direc = "Right";
        } else if (randMovementAmount <= rightBound && randMovementAmount > leftBound) {
            direc = "Left";
        } else if (randMovementAmount <= leftBound && randMovementAmount > downBound) {
            direc = "Down";
        }

        // seperate actual movement from logic to aid with modificaitons
        int movement = (int) randMovementAmount;
        if (direc.equals("Right")) {
            xPosition += movement;
        } else if (direc.equals("Left")) {
            xPosition -= movement;
        } else if (direc.equals("Down")) {
            yPosition += movement;
        }

        return xPosition;
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
        return 10;
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
