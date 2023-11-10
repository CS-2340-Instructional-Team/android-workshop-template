package com.example.demo_2340;

import android.widget.Button;

public class MoveLeft implements MovementStrategyPattern {
    @Override
    public int move(int amount) {
        return -amount;
    }
}
