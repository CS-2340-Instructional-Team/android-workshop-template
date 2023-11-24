package com.example.demo_2340.Enemies_Implementation;

//import android.widget.FrameLayout;
//
//import com.example.demo_2340.CollisionObserver.CollisionManager;
import com.example.demo_2340.CollisionObserver.CollisionObserver;
//import com.example.demo_2340.Player_Movement.MoveDown;
//import com.example.demo_2340.Player_Movement.MoveLeft;
//import com.example.demo_2340.Player_Movement.MoveRight;
//import com.example.demo_2340.Player_Movement.MoveUp;
//import com.example.demo_2340.Player_Movement.MovementStrategyPattern;
//import com.example.demo_2340.R;
//
//import java.util.Random;

public class Sprite implements Enemies, CollisionObserver {
    private String type;
    private double initialXPosition;
    private double initialYPosition;
    private double xPosition;
    private double yPosition;

    public Sprite() {
        type = "Sprite";
        this.initialXPosition = 0;
        this.initialYPosition = 0;
        this.xPosition = initialXPosition;
        this.yPosition = initialYPosition;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double move() {
        /**
        int movementAmount = 30;
        MovementStrategyPattern down = new MoveDown();
        MovementStrategyPattern up = new MoveUp();
        MovementStrategyPattern right = new MoveRight();
        MovementStrategyPattern left = new MoveLeft();

        String [] xDirecArray = {"Right", "Left"};
        String[] yDirecArray = {"Up", "Down"};

        int randMovementIndex = new Random().nextInt(xDirecArray.length);
        String xDirec = xDirecArray[1];
        String yDirec = yDirecArray[0];

        switch (xDirec) {
            case "Right":
                xPosition += right.move(movementAmount);
            case "Left":
                xPosition += left.move(movementAmount);
        }

        switch (yDirec) {
            case "Up":
                yPosition += up.move(movementAmount);
            case "Down":
                yPosition += down.move(movementAmount);
        }

        if (xDirec.equals("Right")) {
            xPosition += right.move(movementAmount);
        } else if (xDirec.equals("Left")) {
            xPosition += left.move(movementAmount);
        } else if (randMovementAmount <= leftBound && randMovementAmount > downBound) {
            direc = "Down";
        }

        //yPosition -= 15;
         **/

        return yPosition;
    }

    @Override
    public double getxPosition() {
        return xPosition;
    }

    @Override
    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    @Override
    public double getyPosition() {
        return yPosition;
    }

    @Override
    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public double getDamage() {
        return 2;
    }


    public void setInitialPosition(double initialX, double initialY) {
        this.initialXPosition = initialX;
        this.initialYPosition = initialY;
        this.xPosition = initialX;
        this.yPosition = initialY;
    }

    @Override
    public void onCollisionDetected(int damage) {

    }
}
