/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jantar;

/**
 *
 * @author andre
 */
public class Jantar {

    Mesa mesa;
    Filosofo filosofos[] = {new Filosofo("1", mesa, 4,0),
         new Filosofo("2", mesa, 0,1), new Filosofo("3", mesa, 1,2),
         new Filosofo("4", mesa, 2,3), new Filosofo("5", mesa, 3,4),
         };
    Thread threads[] = new Thread[5];
    
    public Jantar(){
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(filosofos[i]);
            
        }
    }

    public void go() {
                for (int i = 0; i < 5; i++) {
            threads[i].start();
            
        }

    }

    public void stop() {
                        for (int i = 0; i < 5; i++) {
            filosofos[i].feito();
            
        }

    }

}
