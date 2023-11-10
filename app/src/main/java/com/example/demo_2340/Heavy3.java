package com.example.demo_2340;

public class Heavy3 implements {
    private String type;
    public Heavy3() {
        type = "Heavy3";
    }
    public String getType() {
        return type;
    }
    public void move() {
        double movement = Math.random() * 10.0;
        String direc;
        if (movement <= 10.0 || movement > 7) {
            direc = "Right";
        } else if (movement <= 7 || movement > 5) {
            direc = "Left";
        } else if (movement <= 5 || movement > 3) {
            direc = "Up";
        } else {
            direc = "Down";
        }
    }
}
