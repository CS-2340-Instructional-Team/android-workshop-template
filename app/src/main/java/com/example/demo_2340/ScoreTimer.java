package com.example.demo_2340;

import android.os.Handler;
import android.widget.TextView;

public class ScoreTimer {
    private static int interval = 1000; // Initial interval (in milliseconds)
    private static Handler handler;
    private static Runnable runnable;

    private static GameScreen1 currentGameScreenInstance;

    public static void start() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                // Update the interval if needed
                if (interval == 1) {
                    handler.removeCallbacks(this); // Stop the task
                } else {
                    interval--;
                    handler.postDelayed(this, 1000); // Schedule the task to run again after 1 second
                }
            }
        };
        handler.postDelayed(runnable, 1000); // Start the task immediately (1-second delay)
    }

    private static void updateScore() {
        // Update the score
        int liveScore = getInterval();
        if (currentGameScreenInstance != null) {
            currentGameScreenInstance.runOnUiThread(() -> {
                TextView livescoreTextView = currentGameScreenInstance.findViewById(R.id.livescoreTextView);
                livescoreTextView.setText("Score: " + liveScore);
            });
        }
    }

    public static void setCurrentGameScreenInstance(GameScreen1 gameScreen1) {
        currentGameScreenInstance = gameScreen1;
    }

    public static GameScreen1 getCurrentGameScreenInstance() {
        return currentGameScreenInstance;
    }

    public static int getInterval() {
        return interval;
    }

    public static void stop() {
        handler.removeCallbacks(runnable); // Stop the timer task
    }

    public static void reset() {
        interval = 1000; // Reset the timer task
    }
}
