/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Animal;
import entidade.Veterinario;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.model.SelectItem;

/**
 *
 * @author andre
 */
public class AnimalDAO implements Serializable {

    private static LinkedList<Animal> animais = null;
    private static LinkedList<SelectItem> animaisItems = null;

    public AnimalDAO() {

        if (animais == null) {
            animais = new LinkedList<>();
            Animal a = new Animal(1, "Canídeos");

            a.adicionarEspecialista(1, "Alexandre Otonni");
            animais.add(a);

            a = new Animal(2, "Equinos");
            a.adicionarEspecialista(1, "Andreia Pazos");
            a.adicionarEspecialista(2, "Deive Pazos");
            animais.add(a);

            a = new Animal(3, "Felinos");
            a.adicionarEspecialista(1, "Agatha Otonni");
            a.adicionarEspecialista(2, "Deive Pazos");
            animais.add(a);

        }
        animaisItems = new LinkedList<>();
        animaisItems.add(new SelectItem(null, "Selecione um tipo de Animal!"));
        for (Animal ani : animais) {
            animaisItems.add(new SelectItem(ani, ani.getTipoAnimal()));

        }

    }

    public Animal buscarAnimal(int id) {
        for (Animal animal : animais) {
            if (animal.getId() == id) {
                return animal;
            }

        }
        return null;
    }

    public Veterinario buscarVeterinario(int id) {
        for (Animal animal : animais) {
            for (Veterinario veterinario : animal.getEspecialista()) {

                if (veterinario.getId() == id) {
                    return veterinario;
                }

            }
        }
        return null;
    }

    public LinkedList<Animal> getAnimais() {
        return animais;
    }

    public static void setAnimais(LinkedList<Animal> animais) {
        AnimalDAO.animais = animais;
    }

    public LinkedList<SelectItem> getAnimaisItems() {
        return animaisItems;
    }

    public Animal Cadastra(Animal a) {
        animais.add(a);
        for (Animal ani : animais) {
            animaisItems.add(new SelectItem(ani, ani.getTipoAnimal()));

        }
        return null;
    }

}
