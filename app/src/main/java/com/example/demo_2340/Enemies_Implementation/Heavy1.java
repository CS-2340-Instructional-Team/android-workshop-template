package com.example.demo_2340.Enemies_Implementation;

public class Heavy1 implements Enemies {
    private String type;
    public Heavy1() {
        type = "Heavy";
    }
    public String getType(){
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
