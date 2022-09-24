/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.Categoria;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author andre
 */
@Named(value = "registroBean")
@ApplicationScoped
public class RegistroBean implements Serializable {

    List<Categoria> categorias;

    public RegistroBean() {

        categorias = new LinkedList<>();
        categorias.add(new Categoria("Verduras", new String[]{"Cenoura", "Alfafa", "Couve", "Brocolis", "Espinafre"}));
        categorias.add(new Categoria("Carros", new String[]{"Corsa", "Clio", "Santana", "Fusca", "Marea"}));
        categorias.add(new Categoria("Animais", new String[]{"Cavalo", "Pardal", "Jumento", "Papagaio", "Vaca"}));

    }
        public List<Categoria> getCategorias() {
        return categorias;
    }

    public Categoria getCategoria(String categoria) {
        for (Categoria s : categorias) {
            if (s.getNome().equals(categoria)) {
                return s;
            }
        }
        return null;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.categorias);
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
        final RegistroBean other = (RegistroBean) obj;
        return Objects.equals(this.categorias, other.categorias);
    }

}
