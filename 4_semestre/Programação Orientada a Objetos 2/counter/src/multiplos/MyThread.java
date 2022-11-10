/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiplos;

/**
 *
 * @author aluno
 */
public class MyThread implements Runnable {
    
    Counter c= null;
    public MyThread(Counter c)
    {
        this.c = c;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            c.increment();
            c.decrement();
            c.increment();
            c.decrement();
        }
        

    }
    
    
    
}
