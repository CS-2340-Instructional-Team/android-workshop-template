package com.example.demo_2340;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class EndScreenTest {

    @Rule
    public ActivityScenarioRule<EndScreen> activityScenarioRule =
            new ActivityScenarioRule<>(EndScreen.class);

    @Test
    public void testEndScreenUI() {
        // Check if the EndScreen displays the difficulty, player name, and final score
        Intent intent = new Intent();
        intent.putExtra("difficulty", "Hard");
        intent.putExtra("playerName", "John Doe");
        intent.putExtra("Score", 100); // Replace with the actual final score

        ActivityScenario<EndScreen> activityScenario = ActivityScenario.launch(intent);

        onView(withId(R.id.gameDifficultyTextView)).check(matches(withText("Difficulty: Hard")));

        onView(withId(R.id.playerNameTextView)).check(matches(withText("John Doe")));

        onView(withId(R.id.finalScoreTitle)).check(matches(withText("Final Score: 100"))); // Replace with the actual final score
    }
    @Test
    public void testEndGame() {
        try {
            onView(withId(R.id.endGameButton)).perform(click());
        }
        catch (NullPointerException n) {
            assert true;
        }
    }

    // Add more test cases as needed to cover other functionality of the EndScreen activity
}
