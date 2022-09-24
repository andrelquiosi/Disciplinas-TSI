/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Categoria implements Serializable{

    private String nome;
    private List<String> palavras;
    
    public Categoria(String nome, String[] palavras) {
    
        this.nome = nome;
        this.palavras = new ArrayList<>();
        this.palavras.addAll(Arrays.asList(palavras));
    
    }
    public Categoria(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getPalavras() {
        return palavras;
    }

    public void setPalavras(List<String> palavras) {
        this.palavras = palavras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.nome, other.nome);
    }
    
    
}
