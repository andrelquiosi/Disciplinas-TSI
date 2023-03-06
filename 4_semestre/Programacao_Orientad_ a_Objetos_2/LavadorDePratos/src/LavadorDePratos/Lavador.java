package LavadorDePratos;

public class Lavador implements Runnable {

    private  Escorredor escorredor;
    private PratosSujosFactory pratoSujo;
    private Prato prato;
    private boolean done;

    public Lavador(Escorredor escorredor) {
        this.escorredor = escorredor;
        pratoSujo = new PratosSujosFactory();
    }

    public void lavar() {
        synchronized (escorredor) {
            while (escorredor.isFull()) {
                try {
                    escorredor.wait();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }

            prato = pratoSujo.getNewPrato();
            int milis;

            switch (prato.getNivel_de_sujeira()) {
                case BAIXO:
                    milis = 3;
                    break;
                case MEDIO:
                    milis = 5;
                    break;
                case ENGORDURADO:
                    milis = 10;
                    break;
                default:
                    milis = 10;
            }

            //System.out.println("Lavando");
            try {
                Thread.sleep(milis);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            
            escorredor.coloca(prato);
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
            lavar();
        }
    }

}
