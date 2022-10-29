/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AnimalDAO;
import entidade.Animal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Named(value = "Cadastro")
@SessionScoped
public class Cadastro implements Serializable {

    @Inject
    AnimalDAO cad;
    private String animal, veterinario;
    private int idAnimal, idVeterinario;

    public AnimalDAO getCadastro() {
        return cad;

    }

    public AnimalDAO getCad() {
        return cad;
    }

    public void setCad(AnimalDAO cad) {
        this.cad = cad;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }



    public void Cadastrar() {
        Animal a = new Animal(idAnimal, animal);
        a.adicionarEspecialista(idVeterinario, veterinario);
        cad.Cadastra(a);
    }

}
