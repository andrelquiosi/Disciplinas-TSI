/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exemplo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ExemploThread {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> tarefas;

        tarefas = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Tarefa tarefa;
            tarefa = new Tarefa(i);
            tarefas.add(new Thread(tarefa));
        }
        
        tarefas.stream().forEach(t -> t.start());
        tarefas.get(2).join();
//           tarefas.stream().forEach(t -> {
//            try {
//                t.join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ExemploThread.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        System.out.println("fim");

    }

}
