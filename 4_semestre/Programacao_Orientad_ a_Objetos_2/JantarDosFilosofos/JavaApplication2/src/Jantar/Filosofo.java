/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jantar;

/**
 *
 * @author andre
 */
public class Filosofo implements Runnable {

    private int garfoDireita, garfoEsquerda;
    private volatile boolean feito;

    public static enum State {
        PENSANDO, COMENDO, PEGANDO_GARFO
    };
    Mesa mesa;
    State estado;
    String nome;

    public Filosofo(String nome, Mesa mesa, int garfoEsquerda, int garfoDireita) {
        this.garfoDireita = garfoDireita;
        this.garfoEsquerda = garfoEsquerda;
        this.mesa = mesa;
        this.nome = nome;
        estado = State.PENSANDO;
    }

    public State getState() {
        return estado;
    }

    public void come() {
        estado = State.PEGANDO_GARFO;
        Garfo garfoesquerda;
        Garfo garfodireita;
        do {
            garfoesquerda = mesa.pegaGarfo(garfoEsquerda);

        } while (garfoesquerda == null);

        do {
            garfodireita = mesa.pegaGarfo(garfoDireita);
            estado = State.COMENDO;
        } while (garfodireita == null);

    }

    public void pensa() {
        estado = State.PENSANDO;

    }

    public void feito() {
        this.feito = true;

    }

    @Override
    public void run() {
        feito = false;
        while (!feito) {
            come();
            pensa();

        }
    }

}
