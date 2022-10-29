/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.ConsultaDAO;
import dao.AnimalDAO;
import entidade.Animal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author andre
 */
@Named(value = "veterinariaBean")
@ApplicationScoped
public class VeterinariaBean {

    AnimalDAO animalDao;
    ConsultaDAO consultaDao;

    public VeterinariaBean() {
    }

    @Produces
    public AnimalDAO getVeterinarioDao() {
        if (animalDao == null) {
            animalDao = new AnimalDAO();
        }
        return animalDao;
    }

    @Produces
    public ConsultaDAO getAnimalDao() {
        if (consultaDao == null) {
            consultaDao = new ConsultaDAO();
        }
        return consultaDao;
    }

    @PostConstruct
    public void iniciar() {
        try {
            FileInputStream fis = new FileInputStream("dadosVet.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList<Animal> animais = (LinkedList<Animal>) ois.readObject();
            consultaDao = (ConsultaDAO) ois.readObject();
            AnimalDAO.setAnimais(animais);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void finalizar(){

        try {
            FileOutputStream fos = new FileOutputStream("dadosVet.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animalDao.getAnimais());
            oos.writeObject(consultaDao);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
