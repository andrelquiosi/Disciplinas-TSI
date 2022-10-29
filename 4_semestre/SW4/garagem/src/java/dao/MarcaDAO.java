package dao;

import entidade.Marca;
import entidade.Modelo;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.model.SelectItem;

public class MarcaDAO implements Serializable {

    private static LinkedList<Marca> marcas = null;
    private static LinkedList<SelectItem> marcasItens = null;

    public MarcaDAO() {
        System.out.println("Criando MarcaDAO");
        System.out.flush();
        if (marcas == null) {
            marcas = new LinkedList<>();
            Marca m = new Marca(1, "Volkswagen");
            m.adicionarModelo(1, "Fusca");
            m.adicionarModelo(2, "Gol");
            m.adicionarModelo(3, "Passat");
            m.adicionarModelo(4, "Golf");
            marcas.add(m);

            m = new Marca(2, "Ford");
            m.adicionarModelo(10, "Mustang");
            m.adicionarModelo(11, "Ka");
            m.adicionarModelo(12, "Corcel");
            marcas.add(m);

            m = new Marca(3, "Fiat");
            m.adicionarModelo(20, "500");
            m.adicionarModelo(21, "Uno Escada");
            m.adicionarModelo(22, "Punto Trubo");
            marcas.add(m);
        }
        marcasItens = new LinkedList<>();
        marcasItens.add(new SelectItem(null, "Selecione a marca"));
        for (Marca m1 : marcas) {
            marcasItens.add(new SelectItem(m1, m1.getNome()));
        }
    }

    public Marca buscarMarca(int id) {
        for (Marca m : marcas) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public Modelo buscarModelo(int id) {
        for (Marca m : marcas) {
            for (Modelo md : m.getModelos()) {
                if (md.getId() == id) {
                    return md;
                }
            }
        }
        return null;
    }

    public LinkedList<SelectItem> getMarcasItens() {
        return marcasItens;
    }

    public static LinkedList<Marca> getMarcas() {
        return marcas;
    }

    public static void setMarcas(LinkedList<Marca> marcas) {
        MarcaDAO.marcas = marcas;
    }

}
