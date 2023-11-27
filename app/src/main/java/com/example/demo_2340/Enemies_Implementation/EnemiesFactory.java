package com.example.demo_2340.Enemies_Implementation;

public class EnemiesFactory {
    public static Enemies buildEnemies(String type) {
        String sprite = "Sprite";
        String heavy = "Heavy";
        String heavy2 = "Heavy2";
        String heavy3 = "Heavy3";
        if (type == null || type.isEmpty()) {
            return null;
        } else {
            if (type.equals(sprite)) {
                return new Sprite();
            } else if (type.equals(heavy)) {
                return new Heavy1();
            } else if (type.equals(heavy2)) {
                return new Heavy2();
            } else if (type.equals(heavy3)) {
                return new Heavy3();
            }
            throw new IllegalArgumentException("Unknown Enemy " + type);
        }
    }
}
