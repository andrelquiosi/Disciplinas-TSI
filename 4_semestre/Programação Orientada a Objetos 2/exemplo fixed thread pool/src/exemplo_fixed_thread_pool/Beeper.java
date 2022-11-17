package exemplo_fixed_thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Beeper {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            int i = 0;

            public void run() {
                System.out.println("beep_" + ++i);
            }
        };
        final ScheduledFuture<?> beeperHandle
                = scheduler.scheduleAtFixedRate(beeper, 5, 5, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() {
                beeperHandle.cancel(true);
                System.out.println(" beep_Finalizado ");
                scheduler.shutdown();
            }
        }, 3600, TimeUnit.SECONDS);
    }

    public static void main(String args[]) {
        Beeper bp = new Beeper();
        bp.beepForAnHour();
    }
}
