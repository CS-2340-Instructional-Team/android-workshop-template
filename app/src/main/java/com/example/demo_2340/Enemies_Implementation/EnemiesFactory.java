package com.example.demo_2340.Enemies_Implementation;

public class EnemiesFactory {
    public static Enemies buildEnemies(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        } else {
            if (type.equals("Sprite")) {
                return new Sprite();
            } else if (type.equals("Heavy")) {
                return new Heavy1();
            } else if (type.equals("Heavy2")) {
                return new Heavy2();
            } else if (type.equals("Heavy3")) {
                return new Heavy3();
            }
            throw new IllegalArgumentException("Unknown Enemy " + type);
        }
    }
}
