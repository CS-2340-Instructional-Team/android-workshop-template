package com.example.demo_2340;

public class MoveUp implements MovementStrategyPattern {
    @Override
    public int move(int amount) {
        return -amount;
    }
}
