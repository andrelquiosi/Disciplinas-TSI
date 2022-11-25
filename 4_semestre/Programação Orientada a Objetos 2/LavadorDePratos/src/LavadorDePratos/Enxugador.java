package LavadorDePratos;

import java.util.Random;

public class Enxugador implements Runnable {

    private Escorredor escorredor;
    private boolean done;

    public Enxugador(Escorredor escorredor) {
        this.escorredor = escorredor;
    }

    public void enxugar() {
        
        Random rand = new Random();
        
        synchronized (escorredor) {
            
            while (escorredor.isEmpty()) {
                try {
                    escorredor.wait();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }

            //System.out.println("Enxugando");
            try {
                Thread.sleep(rand.nextInt(7) + 3);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            
            escorredor.pega();
            escorredor.notifyAll();

        }

    }

    public void done() {
        this.done = true;
    }

    @Override
    public void run() {
        done = false;
        while (!done) {
            enxugar();
        }
    }

}
