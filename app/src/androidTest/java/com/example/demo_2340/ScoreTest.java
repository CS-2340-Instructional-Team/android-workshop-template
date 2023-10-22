package com.example.demo_2340;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class ScoreTest {

    @Rule
    public ActivityScenarioRule<GameScreen1> activityScenarioRule =
            new ActivityScenarioRule<>(GameScreen1.class);

    @Test
    public void testScore1() {
        // Check if the score function works properly
        Intent intent = new Intent();
        intent.putExtra("difficulty", "Hard");
        intent.putExtra("playerName", "John Doe");
        intent.putExtra("Score", 1000); // Replace with the actual final score

        ActivityScenario<GameScreen1> activityScenario = ActivityScenario.launch(intent);

        onView(withId(R.id.scoreTextView)).check(matches(withText("Score: 1000")));

    }
    @Test
    public void testScore2() {
        Intent intent = new Intent();
        intent.putExtra("difficulty", "Hard");
        intent.putExtra("Name", "John Doe");
        intent.putExtra("Score: ", 995);

        ActivityScenario<GameScreen2> activityScenario = ActivityScenario.launch(intent);

        onView(withId(R.id.scoreTextView)).check(matches(withText("Score: 995")));
    }
    @Test
    public void testScore3() {
        Intent intent = new Intent();
        intent.putExtra("difficulty", "Hard");
        intent.putExtra("Name", "John Doe");
        intent.putExtra("Score: ", 995);

        ActivityScenario<GameScreen3> activityScenario = ActivityScenario.launch(intent);

        onView(withId(R.id.scoreTextView)).check(matches(withText("Score: 995")));
    }

    // Add more test cases as needed to cover other functionality of the EndScreen activity
}
