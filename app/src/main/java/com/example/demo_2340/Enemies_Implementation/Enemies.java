package com.example.demo_2340.Enemies_Implementation;

public interface Enemies {
    String getType();
    double move();

    double getxPosition();

    void setxPosition(double xPosition);

    double getyPosition();

    void setyPosition(double yPosition);

    double getDamage();

    void setInitialPosition(double x, double y);

    void onCollisionDetected(int i);
}
