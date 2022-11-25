

import provapratica.parte2a.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ThreadB implements Runnable {

    boolean onoff = true;

    @Override
    public void run() {
        do {
            System.out.println("Olá B");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadB.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (onoff);
    }

    public void stopThread() {
        onoff = false;
    }

}
