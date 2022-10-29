package entidade;

import java.io.Serializable;

public class Modelo implements Serializable {
    
    private int id;
    private String nome;
    private Marca marca;

    public Modelo(int id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }
    
    public Modelo() { }

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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
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
        final Modelo other = (Modelo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
