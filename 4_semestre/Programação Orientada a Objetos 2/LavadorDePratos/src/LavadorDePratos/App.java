package LavadorDePratos;

public class App {

    private Thread t1;
    private Thread t2;
    private Escorredor escorredor;
    private Lavador lavador;
    private Enxugador enxugador;

    public static void main(String args[]) {

        App lavarPratos = new App();

        lavarPratos.work();

        try {
            Thread.sleep(1000 * 120);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        lavarPratos.stop();
    }

    public App() {
        escorredor = new Escorredor(10);
        lavador = new Lavador(escorredor);
        enxugador = new Enxugador(escorredor);
        t1 = new Thread(lavador);
        t2 = new Thread(enxugador);
    }

    public void work() {
        t1.start();
        t2.start();
    }

    public void stop() {
        lavador.done();
        enxugador.done();
    }

}
