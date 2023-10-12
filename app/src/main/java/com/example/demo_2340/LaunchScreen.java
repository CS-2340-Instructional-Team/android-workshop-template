package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        // Find the button and EditText by their IDs
        Button startButton = findViewById(R.id.launchScreenStart);
        EditText playerNameEditText = findViewById(R.id.playerNameEditText);

        // Set a click listener for the button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the player's name from the EditText
                String playerName = playerNameEditText.getText().toString().trim();

                // Check if the player's name is not empty
                if (!playerName.isEmpty()) {
                    // Proceed to the next activity
                    Toast.makeText(LaunchScreen.this, "Starting Game", Toast.LENGTH_SHORT).show();

                    // You can pass the player's name to the next activity using an Intent if needed
                    Intent intent = new Intent(LaunchScreen.this, SelectCharacter.class);
                    intent.putExtra("playerName", playerName); // Pass the player's name
                    startActivity(intent);
                } else {
                    // Display an error message if the player's name is empty
                    Toast.makeText(LaunchScreen.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
