package beans;

import dao.MarcaDAO;
import dao.VeiculoDAO;
import entidade.Marca;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Named(value = "marcasBean")
@ApplicationScoped
public class MarcasBean {

    MarcaDAO marcaDAO;
    VeiculoDAO veiculoDAO;

    public MarcasBean() {
    }

    @Produces
    public MarcaDAO getMarcaDAO() {
        if (marcaDAO == null) {
            marcaDAO = new MarcaDAO();
        }
        return marcaDAO;
    }

    @Produces
    public VeiculoDAO getVeiculoDAO() {
        if (veiculoDAO == null) {
            veiculoDAO = new VeiculoDAO();
        }
        return veiculoDAO;
    }

    @PostConstruct
    public void iniciar() {
        try {
            FileInputStream fis = new FileInputStream("dados.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList<Marca> marcas = (LinkedList<Marca>) ois.readObject();
            veiculoDAO = (VeiculoDAO) ois.readObject();
            MarcaDAO.setMarcas(marcas);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void finalizar() {
        System.out.println("Este é o ponto para salvar os objetos em um arquivo...");
        try {
            FileOutputStream fos = new FileOutputStream("dados.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject( marcaDAO.getMarcas() );
            oos.writeObject( veiculoDAO );
            oos.flush();
            fos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
