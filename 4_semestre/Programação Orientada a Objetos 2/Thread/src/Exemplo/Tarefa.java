/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tarefa implements Runnable {

    int valor;
    Random random = new Random();

    Tarefa(int i) {
        this.valor = i;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public void run() {
        System.out.println("Hello thread " + getValor());
        int tempo = random.nextInt(3000 - 1000) + 1000;
        try {
            Thread.sleep(tempo);
            System.out.println("Encerando thread " + getValor());
        } catch (InterruptedException ex) {
            Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
