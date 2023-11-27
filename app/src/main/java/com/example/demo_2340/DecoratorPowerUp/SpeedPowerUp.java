package com.example.demo_2340.DecoratorPowerUp;

import com.example.demo_2340.Player;

public class SpeedPowerUp extends PowerUpDecorator {
    public SpeedPowerUp(PowerUp healthPower) {
        super(healthPower);
    }

    @Override
    public void powerUpHero(Player hero) {
        super.powerUpHero(hero);
        speedPowerMethod(hero);
    }
//testing
    private void speedPowerMethod(Player hero) {
        hero.setSpeed(2);
    }
}
