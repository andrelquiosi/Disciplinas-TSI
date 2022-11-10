package Jantar;

import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jshell.execution.Util;

public class App {

    public static void main(String[] args) {

        Jantar janta = new Jantar();
        janta.go();
        try {
            Thread.sleep(1000 * 60 * 5);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        janta.stop();
    }

}
