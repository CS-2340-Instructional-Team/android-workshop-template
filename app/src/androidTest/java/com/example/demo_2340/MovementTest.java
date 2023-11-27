package com.example.demo_2340;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
public class MovementTest {

    @Rule
    public ActivityScenarioRule<GameScreen1> activityScenarioRule =
            new ActivityScenarioRule<>(GameScreen1.class);
    @Test
    public void moveUpTest() {
        onView(withId(R.id.buttonUp)).perform(click());
    }
    @Test
    public void moveDownTest() {
        onView(withId(R.id.buttonDown)).perform(click());
    }
    @Test
    public void moveRightTest() {
        onView(withId(R.id.buttonRight)).perform(click());
    }
    @Test
    public void moveLeftTest() {
        onView(withId(R.id.buttonLeft)).perform(click());
    }
}
