package com.example.demo_2340.Enemies_Implementation;

public class Heavy1 implements Enemies {
    private String type;
    private double xPosition;
    private double yPosition;
    public Heavy1() {
        this.xPosition = 0;
        this.yPosition = 0;
        type = "Heavy";
    }
    private double randomMultiplier = 10.0;
    private int rightBound = 7;
    private int leftBound = 5;
    private int upBound = 3;
    public String getType(){
        return type;
    }
    public double move() {
        double movement = Math.random() * randomMultiplier;
        String direc;
        if (movement <= randomMultiplier && movement > rightBound) {
            direc = "Right";
        } else if (movement <= rightBound && movement > leftBound) {
            direc = "Left";
        } else if (movement <= leftBound && movement > upBound) {
            direc = "Up";
        } else {
            direc = "Down";
        }
        return movement;
    }
    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }
}
