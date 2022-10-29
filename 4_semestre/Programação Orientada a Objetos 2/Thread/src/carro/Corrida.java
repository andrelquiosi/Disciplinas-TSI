/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Corrida {

    public static void main(String[] args) throws InterruptedException {
        
        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Thread> corrida = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Carro carro = new Carro(i);
            carros.add(carro);
            corrida.add(new Thread(carro));
        }

        corrida.forEach(t -> {t.start();});
        
        corrida.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        carros.stream().min(Comparator.comparing(Carro::getTempo)).ifPresent(c -> System.out.println(c.getId()));
        
    }

}
