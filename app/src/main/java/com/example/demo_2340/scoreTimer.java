package com.example.demo_2340;
import java.util.Timer;
import java.util.TimerTask;
public class scoreTimer {
    private static int interval;
    private static Timer timer;

    public static void main(String[] args) {
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 1000;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                setInterval();

            }
            }, delay, period);
        }
        private static final int setInterval() {
            if (interval == 1)
                timer.cancel();
            return --interval;
        }
        public static int getInterval() {
        return interval;
        }
}
