package com.example.demo_2340.Enemies_Implementation;

public class EnemiesFactory {
    public static Enemies buildEnemies(String type) {
        String type1 = "Sprite";
        String type2 = "Heavy";
        String type3 = "Heavy2";
        String type4 = "Heavy3";
        if (type == null || type.isEmpty()) {
            return null;
        } else {
            if (type.equals(type1)) {
                return new Sprite();
            } else if (type.equals(type2)) {
                return new Heavy1();
            } else if (type.equals(type3)) {
                return new Heavy2();
            } else if (type.equals(type4)) {
                return new Heavy3();
            }
            throw new IllegalArgumentException("Unknown Enemy " + type);
        }
    }
}
