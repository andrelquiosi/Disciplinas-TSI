package entidade;

import java.io.Serializable;
import java.util.LinkedList;

public class Marca implements Serializable {

    private int id;
    private String nome;
    private LinkedList<Modelo> modelos;

    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
        modelos = new LinkedList<>();
    }

    public Marca() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LinkedList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(LinkedList<Modelo> modelos) {
        this.modelos = modelos;
    }

    public void adicionarModelo(int idModelo, String nome) {
        Modelo m = new Modelo(idModelo, nome, this);
        modelos.add(m);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Marca other = (Marca) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
