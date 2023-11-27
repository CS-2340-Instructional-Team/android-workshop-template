package com.example.demo_2340.DecoratorPowerUp;

import com.example.demo_2340.Player;

public class HealthPowerUp extends PowerUpDecorator {
    public HealthPowerUp(PowerUp healthPower) {
        super(healthPower);
    }

    @Override
    public void powerUpHero(Player hero) {
        super.PowerUpHero(hero);
        healthPowerMethod(hero);
    }

    private void healthPowerMethod(Player hero) {
        hero.setHealth(200);
    }
}
