package com.example.demo_2340.DecoratorPowerUp;

import com.example.demo_2340.Player;

public abstract class PowerUpDecorator implements PowerUp {
    private PowerUpBase powerUp;

    public PowerUpDecorator(PowerUp powerUp) {
        this.powerUp = new PowerUpBase();
    }

    public void PowerUpHero(Player hero) {
        this.powerUpHero(hero);
    }
}
