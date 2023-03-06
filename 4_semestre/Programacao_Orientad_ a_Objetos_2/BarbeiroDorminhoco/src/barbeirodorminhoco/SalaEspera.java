package barbeirodorminhoco;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author c-diego
 */
public class SalaEspera {

    private final ArrayBlockingQueue<Cliente> fila;

    public SalaEspera(int MAX) {
        fila = new ArrayBlockingQueue<>(MAX);
    }

    public boolean isFull() {
        return fila.remainingCapacity() <= 0;
    }

    public boolean isEmpty() {
        return fila.isEmpty();
    }

    public boolean put(Cliente cliente) {
        if (!isFull())
            try {
                fila.put(cliente);
                return true;
        } catch (InterruptedException ex) {}
        return false;
    }

    public Cliente remove() {
        try {
            return fila.take();
        } catch (InterruptedException ex) {}
        return null;
    }

    public int getSize() {
        return fila.size();
    }
}
