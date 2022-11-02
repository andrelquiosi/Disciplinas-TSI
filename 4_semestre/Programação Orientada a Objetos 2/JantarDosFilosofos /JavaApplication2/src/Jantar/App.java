package Jantar;

import jdk.jshell.execution.Util;

public class App {

    public static void main(String[] args) {

        Jantar janta = new Jantar();
        janta.go();
        Util.waitFor(1000 * 60 * 5);
        janta.stop();
    }

}
