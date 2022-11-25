/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provapratica.parte2a;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ArrayList<Thread> tredee = new ArrayList<>();

        ThreadA ta = new ThreadA();
        tredee.add(new Thread((Runnable) ta));

        ThreadB tb = new ThreadB();
        tredee.add(new Thread((Runnable) tb));

        tredee.forEach(t -> {
            t.start();
        });
        Thread.sleep(30000);
        for (int i = 0; i < 2; i++) {
            tredee.get(i).getClass();

        }

    }

}
