/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carro;

import java.time.Instant;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carro implements Runnable {

    int id;
    Instant tempo;
    Random random = new Random();

    public Carro(int id) {
        this.id = id;
    }

    public Instant getTempo() {
        return tempo;
    }

    public int getId() {
        return id;
    }
    
    
    public void run() {

        for (int etapa = 1; etapa < 11; etapa++) {
            int temp = random.nextInt(1000 - 500) + 500;
            System.out.println("O carro '" + id + "' está na posição :" + etapa);
            try {
                Thread.sleep(temp);
            } catch (InterruptedException ex) {
                Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tempo = Instant.now();
//        System.out.println(tempo);

    }
    
}
