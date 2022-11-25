package barbeirodorminhoco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author c-diego
 */
public class Cliente implements Runnable {

    private final SalaEspera fila;
    private final Lock lock;
    private final Condition condition;
    private volatile boolean done;

    public Cliente(SalaEspera fila, Lock lock, Condition condition) {
        this.fila = fila;
        this.lock = lock;
        this.condition = condition;
    }

    public void entrarBarbearia() {
        lock.lock();
        try {
            if (fila.isFull()) {
                System.out.println("Fila cheia, cliente foi embora.");
                done();
            } else {
                fila.put(this);
                System.out.println(fila.getSize());
                condition.signalAll();
            }
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
            entrarBarbearia();
        }
    }
}
