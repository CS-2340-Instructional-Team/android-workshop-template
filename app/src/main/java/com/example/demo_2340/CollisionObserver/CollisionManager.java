package com.example.demo_2340.CollisionObserver;

import android.view.View;

import android.widget.ImageView;


import com.example.demo_2340.Enemies_Implementation.Enemies;
import com.example.demo_2340.Player;


public class CollisionManager {

    public static void checkCollisions(Player player, Enemies enemy1,
                                       Enemies enemy2, ImageView playerImageView,
                                       ImageView enemyImageView1, ImageView enemyImageView2) {

        if (isViewOverlapping(playerImageView, enemyImageView1)) {
            player.onCollisionDetected((int) enemy1.getDamage());
            enemy1.onCollisionDetected(0);
        }

        if (isViewOverlapping(playerImageView, enemyImageView2)) {
            player.onCollisionDetected((int) enemy2.getDamage());
            enemy2.onCollisionDetected(0);
        }
    }

    public static boolean isViewOverlapping(View firstView, View secondView) {
        int[] firstPosition = new int[2];
        int[] secondPosition = new int[2];

        firstView.getLocationOnScreen(firstPosition);
        secondView.getLocationOnScreen(secondPosition);

        int firstX = firstPosition[0];
        int firstY = firstPosition[1];
        int secondX = secondPosition[0];
        int secondY = secondPosition[1];

        return firstX < secondX + secondView.getWidth()
                && firstX + firstView.getWidth() > secondX
                && firstY < secondY + secondView.getHeight()
                && firstY + firstView.getHeight() > secondY;
    }
}

