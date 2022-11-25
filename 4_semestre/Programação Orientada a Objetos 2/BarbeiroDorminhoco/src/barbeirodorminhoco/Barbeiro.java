package barbeirodorminhoco;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author c-diego
 */
public class Barbeiro implements Runnable {

    private final SalaEspera fila;
    private final Lock lock;
    private final Condition condition;
    private volatile boolean done;

    public Barbeiro(SalaEspera fila, Lock lock, Condition condition) {
        this.fila = fila;
        this.lock = lock;
        this.condition = condition;
    }

    public void trabalhar() {
        lock.lock();
        try {
            while (fila.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException ex) {}
            }

            System.out.println("Barbeiro atendendo cliente.");

            Random rand = new Random();
            int milis = rand.nextInt(10000) + 1;

            try {
                Thread.sleep(milis);
            } catch (InterruptedException ex) {}

            Cliente cliente = fila.remove();

            System.out.println("Barbeiro terminou de atender o cliente: " + cliente);
        } finally {
            lock.unlock();
        }
    }

    public void done() {
        done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            trabalhar();
        }
    }
}
