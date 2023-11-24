package com.example.demo_2340;

import android.content.Intent;
import android.widget.RadioButton;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SelectCharacterTest {

    @Rule
    public ActivityScenarioRule<SelectCharacter> activityScenarioRule =
            new ActivityScenarioRule<>(SelectCharacter.class);

    @Test
    public void testSelectCharacter() {
        // Type the player name into an EditText (assuming you have an EditText with id playerNameEditText)


        // Assuming there is a RadioGroup with id characterRadioGroup within the SelectCharacter activity
        ActivityScenario<SelectCharacter> activityScenario = activityScenarioRule.getScenario();
        activityScenario.onActivity(activity -> {
            RadioButton radioButton = activity.findViewById(R.id.characterRadioGroup);
            radioButton.setChecked(true);
        });

        // Wait for a moment if needed
        // Espresso.onView(withId(R.id.someViewId)).perform(waitFor(2000));

        // Click on the "Next" button again
        onView(withId(R.id.nextButton)).perform(click());

        // You can then perform assertions within the SelectCharacter activity as needed.
    }
    @Test
    public void testEmptyInputAndToastCharacter() {
        // Don't type anything into the EditText (empty input)

        // Click on the "Start" button
        onView(withId(R.id.nextButton)).perform(click());
    }
}
