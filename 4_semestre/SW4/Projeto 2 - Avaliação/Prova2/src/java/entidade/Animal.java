/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.io.Serializable;
import java.util.LinkedList;

public class Animal implements Serializable {

    private String tipoAnimal;
    private LinkedList<Veterinario> especialista;
    private int id;

    public Animal(int id, String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
        this.id = id;
        especialista = new LinkedList<>();
    }

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void adicionarEspecialista(int id, String nome) {

        Veterinario a = new Veterinario(id, nome, this);
        especialista.add(a);
    }

    public LinkedList<Veterinario> getEspecialista() {
        return especialista;
    }

    public void setEspecialista(LinkedList<Veterinario> especialista) {
        this.especialista = especialista;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }

}
