package com.example.demo_2340;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertTrue;

import android.widget.RadioButton;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.demo_2340.Enemies_Implementation.Heavy1;
import com.example.demo_2340.Enemies_Implementation.Heavy2;
import com.example.demo_2340.Enemies_Implementation.Heavy3;
import com.example.demo_2340.Enemies_Implementation.Sprite;

import org.junit.Rule;
import org.junit.Test;

public class SpriteRandomMovementTest {


    @Test
    public void testSpriteRandomMovement() {
        Sprite s1 = new Sprite();
        double movement1 = s1.move();
        double movement2 = s1.move();
        double movement3 = s1.move();
        assertTrue(movement3 != movement1 && movement3 != movement2);
    }
    @Test
    public void testHeavy1RandomMovement() {
        Heavy1 h1 = new Heavy1();
        double m1 = h1.move();
        double m2 = h1.move();
        double m3 = h1.move();
        assertTrue(m1 != m2 && m1 != m3);
    }
    @Test
    public void testHeavy2RandomMovement() {
        Heavy2 h2 = new Heavy2();
        double m1 = h2.move();
        double m2 = h2.move();
        double m3 = h2.move();
        assertTrue(m1 != m2 && m1 != m3);
    }
    @Test
    public void testHeavy3RandomMovement() {
        Heavy3 h3 = new Heavy3();
        double m1 = h3.move();
        double m2 = h3.move();
        double m3 = h3.move();
        assertTrue(m1 != m2 && m1 != m3);
    }


}
