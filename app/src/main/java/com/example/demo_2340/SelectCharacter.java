package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SelectCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);

        // Find the "Next" button by its ID
        Button nextButton = findViewById(R.id.nextButton);
        Intent previousIntent = getIntent();
        String playerName = previousIntent.getStringExtra("playerName");

        // Set a click listener for the "Next" button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected character
                RadioGroup characterRadioGroup = findViewById(R.id.characterRadioGroup);
                int selectedRadioButtonId = characterRadioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedCharacter = selectedRadioButton.getText().toString();

                    // Display a toast message with the selected character
                    Toast.makeText(SelectCharacter.this,
                            "Selected Character: " + selectedCharacter, Toast.LENGTH_SHORT).show();

                    // Start a new activity (SelectDifficultyActivity)
                    Intent intent = new Intent(SelectCharacter.this, SelectDifficulty.class);
                    intent.putExtra("playerName", playerName);
                    startActivity(intent);
                } else {
                    // No character selected
                    Toast.makeText(SelectCharacter.this,
                            "Please Select a Character", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
