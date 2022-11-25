/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import provapratica.parte2a.*;

/**
 *
 * @author andre
 */
public class ThreadA {

    boolean onoff = true;

    public ThreadA() throws InterruptedException {
        do {
            System.out.println("Olá A");
            Thread.sleep(5000);

        } while (onoff);

    }

    public void stopThread() {
        onoff = false;
    }
}
