package com.example.demo_2340;

import android.os.Handler;
public class ScoreTimer {
    private static int intitinterval = 1000; // Initial interval (in milliseconds)
    private static int interval = intitinterval;
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
                    handler.postDelayed(this,
                            1000); // Schedule the task to run again after 1 second
                }
            }
        };
        handler.postDelayed(runnable, 1000); // Start the task immediately (1-second delay)
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
        interval = intitinterval; // Reset the timer task
    }
}
