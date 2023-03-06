/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thread;

/**
 *
 * @author aluno
 */
public class TesteThreadRunnable implements Runnable {

    public static void main(String[] args) {
       (new Thread( new TesteThreadRunnable() )).start();
    }

    @Override
    public void run() {
        System.out.println("TesteThreadRunnable");
    }

}
