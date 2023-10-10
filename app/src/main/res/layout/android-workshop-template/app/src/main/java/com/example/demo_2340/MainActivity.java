package com.example.demo_2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/res/layout/android-workshop-template/app/src/main/java/com/example/demo_2340/MainActivity.java
        setContentView(R.layout.activity_game_screen3);
        Button startBtn = findViewById(R.id.nextButton);
=======
        setContentView(R.layout.config_screen);
        Button startBtn = findViewById(R.id.startButton);
>>>>>>> main:app/src/main/java/com/example/demo_2340/MainActivity.java

        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            RadioGroup characterRadioGroup = findViewById(R.id.characterRadioGroup);
            double character = 1;

            switch (characterRadioGroup.getCheckedRadioButtonId()) {
                case R.id.zeusOption:
                    character = 0.5;
                    break;
                case R.id.poseidonOption:
                    character = 0.75;
                    break;
                case R.id.hadesOption:
                    character = 1;
                    break;
                default:
                    character = 0.5;
                    break;
            }
<<<<<<< HEAD:app/src/main/res/layout/android-workshop-template/app/src/main/java/com/example/demo_2340/MainActivity.java

            game.putExtra("difficulty", difficulty);
=======
            Intent game = new Intent(MainActivity.this, GameActivity.class);
            game.putExtra("Character", character);
>>>>>>> main:app/src/main/java/com/example/demo_2340/MainActivity.java
            startActivity(game);
            finish();
        });
    }
}