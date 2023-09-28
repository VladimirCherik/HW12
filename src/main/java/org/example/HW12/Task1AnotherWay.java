package org.example.HW12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Task1AnotherWay {
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        new Task1AnotherWay().mainAction();
    }

    public void mainAction() {
        final Runnable firstTimer = new Runnable() {
            int t ;
            public void run() {
                System.out.printf("the %s sec has passed\n", t++);

            }
        };
        ScheduledFuture<?> firstTimerHandle = scheduler.scheduleAtFixedRate(firstTimer, 0, 1, SECONDS);

        Runnable secondTimer = new Runnable() {
            int t = 0;
            public void run() {
                System.out.printf("the %s sec has passed, secondTimer  \n", t += 5);
            }
        };
        ScheduledFuture<?> secondTimerHandle = scheduler.scheduleAtFixedRate(secondTimer, 5, 5, SECONDS);


        Runnable runnableFinish = () -> {
            firstTimerHandle.cancel(true);
            secondTimerHandle.cancel(true);

            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(800, MILLISECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
            }
        };
        scheduler.schedule(runnableFinish, 30, SECONDS);



    }
}
