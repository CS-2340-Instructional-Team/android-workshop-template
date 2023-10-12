package com.example.demo_2340;

import android.widget.RadioButton;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SelectDifficultyTest {

    @Rule
    public ActivityScenarioRule<SelectDifficulty> activityScenarioRule =
            new ActivityScenarioRule<>(SelectDifficulty.class);

    @Test
    public void testSelectDifficulty() {

        // Assuming there is a RadioGroup with id difficultyRadioGroup within the SelectDifficulty activity
        ActivityScenario<SelectDifficulty> activityScenario = activityScenarioRule.getScenario();
        activityScenario.onActivity(activity -> {
            RadioButton radioButton = activity.findViewById(R.id.difficultyRadioGroup);
            radioButton.setChecked(true);
        });

        // Wait for a moment if needed
        // Espresso.onView(withId(R.id.someViewId)).perform(waitFor(2000));

        // Click on the start button
        onView(withId(R.id.startButton)).perform(click());

        // You can then perform assertions within the SelectDifficulty activity as needed.
    }
}
