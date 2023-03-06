package barbeirodorminhoco;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author c-diego
 */
public class Recepcionista implements Runnable {

    private volatile boolean done;
    private final Random rand;
    private final SalaEspera fila;
    private final Lock lock;
    private final Condition condition;

    public Recepcionista(SalaEspera fila, Lock lock, Condition condition) {
        this.fila = fila;
        this.lock = lock;
        this.condition = condition;
        rand = new Random();
        done = false;
    }

    public void newCliente() {
        int milis = rand.nextInt(10000) + 1;
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {}

        Cliente cliente = new Cliente(fila, lock, condition);
        Thread t1 = new Thread(cliente);
        t1.start();
    }

    @Override
    public void run() {
        while (!done) {
            newCliente();
        }
    }
}
