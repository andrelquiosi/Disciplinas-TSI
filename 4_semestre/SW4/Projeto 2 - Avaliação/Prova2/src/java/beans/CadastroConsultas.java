/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.ConsultaDAO;
import dao.ConsultaJaCadastrado;
import dao.AnimalDAO;
import entidade.Animal;
import entidade.Consulta;
import entidade.Veterinario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Named(value = "cadastroConsultas")
@SessionScoped
public class CadastroConsultas implements Serializable {

    @Inject
    ConsultaDAO consultaDao;

    @Inject
    AnimalDAO animalDao;

    private Consulta consulta;
    private Animal animalEscolhido;
    private boolean editando = false;
    private List<Integer> invalidDays;

    public CadastroConsultas() {

    }

    @PostConstruct
    public void init() {
        // Neste ponto, os daos já foram injetados. Poderiam ser usados.
        consulta = new Consulta();

        invalidDays = new ArrayList<>();
        invalidDays.add(0);
        invalidDays.add(1);
        invalidDays.add(5);
        invalidDays.add(6);
    }

    public List<Integer> getInvalidDays() {
        return invalidDays;
    }

    public ConsultaDAO getConsultaDao() {
        return consultaDao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Animal getAnimalEscolhido() {
        return animalEscolhido;
    }

    public void setAnimalEscolhido(Animal animalEscolhido) {
        this.animalEscolhido = animalEscolhido;
    }

    public List<SelectItem> getAnimaisItens() {
        return animalDao.getAnimaisItems();
    }

    public List<SelectItem> getVeterinariosItens() {
        if (animalEscolhido == null) {
            return new LinkedList<>();
        }
        LinkedList<SelectItem> itens = new LinkedList<>();
        itens.add(new SelectItem(null, "Selecione o(a) Veterinário(a)"));
        for (Veterinario vet : animalEscolhido.getEspecialista()) {
            itens.add(new SelectItem(vet, vet.getNome()));
        }
        return itens;
    }

    public String confirmar() {
        if (!editando ) {
            try {
                consultaDao.incluir(consulta);
            } catch (ConsultaJaCadastrado vjc) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Já existe uma consulta"));
            }
        }
        editando = false;
        consulta = new Consulta();
        return null;
    }

    public void remover(Consulta con) {
        consultaDao.remover(con);
    }

    public void editar(Consulta con) {
        consulta = con;
        editando = true;
    }

    public String cancelar() {
        editando = false;
        consulta = new Consulta();
        return null;
    }

}
