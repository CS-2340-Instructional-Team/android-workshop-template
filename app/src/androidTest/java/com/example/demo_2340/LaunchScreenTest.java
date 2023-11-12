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

public class LaunchScreenTest {

    @Rule
    public ActivityScenarioRule<LaunchScreen> activityScenarioRule =
            new ActivityScenarioRule<>(LaunchScreen.class);

    @Test
    public void testValidInputAndStart() {
        // Type a valid player name into the EditText (assuming you have an EditText with id playerNameEditText)
        String playerName = "John Doe";
        onView(withId(R.id.playerNameEditText)).perform(typeText(playerName));

        // Click on the "Start" button
        onView(withId(R.id.launchScreenStart)).perform(click());

//        // Verify that the intent to start the SelectCharacter activity was sent
//        ActivityScenario<LaunchScreen> activityScenario = activityScenarioRule.getScenario();
//        activityScenario.onActivity(activity -> {
//            Intent nextIntent = activity.getIntent();
//            String nextActivityName = nextIntent.getComponent().getClassName();
//            // Make sure it's starting the SelectCharacter activity
//            assert (nextActivityName.equals(SelectCharacter.class.getName()));
//            // Check if playerName is passed to the next activity
//            String passedPlayerName = nextIntent.getStringExtra("playerName");
//            assert (playerName.equals(passedPlayerName));
//        });
    }

    @Test
    public void testEmptyInputAndToast() {
        // Don't type anything into the EditText (empty input)

        // Click on the "Start" button
        onView(withId(R.id.launchScreenStart)).perform(click());

        // Verify that a toast message is displayed indicating the need to enter a name
        // (assert the behavior without using ToastMatcher)
        // You can assert the toast message text using other means as needed.
    }
}
