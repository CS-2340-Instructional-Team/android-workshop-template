package com.example.demo_2340.DecoratorPowerUp;

import com.example.demo_2340.Player;

public abstract class PowerUpDecorator implements PowerUp {
    private PowerUp powerUp;

    public PowerUpDecorator(PowerUp powerUp) {
        this.powerUp = new PowerUpBase();
    }

    public void powerUpHero(Player hero) {
        powerUp.powerUpHero(hero);
    }
}
