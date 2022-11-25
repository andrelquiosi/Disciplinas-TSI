package barbeirodorminhoco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author c-diego
 */
public class Barbearia {

    public static void main(String args[]) throws InterruptedException {
        SalaEspera fila = new SalaEspera(5);
        Lock lock = new ReentrantLock();
        Condition condiiton = lock.newCondition();

        Barbeiro barbeiro = new Barbeiro(fila, lock, condiiton);
        Recepcionista recepcionista = new Recepcionista(fila, lock, condiiton);

        Thread t1 = new Thread(barbeiro);
        Thread t2 = new Thread(recepcionista);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
