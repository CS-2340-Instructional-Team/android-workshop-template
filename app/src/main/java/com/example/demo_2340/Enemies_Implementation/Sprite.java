package com.example.demo_2340.Enemies_Implementation;

public class Sprite implements Enemies {
    private String type;
    private double xPosition;
    private double yPosition;

    public Sprite() {

        type = "Sprite";
        this.xPosition = 0;
        this.yPosition = 0;
    }
    public String getType() {
        return type;
    }
    public double move() {
        double movement = Math.random() * 10.0;
        String direc;
        if (movement <= 10.0 && movement > 7) {
            direc = "Right";
        } else if (movement <= 7 && movement > 5) {
            direc = "Left";
        } else if (movement <= 5 && movement > 3) {
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
