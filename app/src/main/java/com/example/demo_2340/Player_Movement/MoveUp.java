package com.example.demo_2340.Player_Movement;

public class MoveUp implements MovementStrategyPattern {
    @Override
    public int move(int amount) {
        return -amount;
    }
}
