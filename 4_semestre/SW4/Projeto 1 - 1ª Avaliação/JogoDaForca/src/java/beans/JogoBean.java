/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dados.Categoria;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 *
 * @author andre
 */
@Named(value = "jogoBean")
@SessionScoped
public class JogoBean implements Serializable {

    private Categoria catSelecionada;
    private Random rand = new Random();
    private String sorteada, acertos, letras, letra, finalizadas;
    private int erros, derrotas;

    public JogoBean() {
    }

    public Categoria getCatSelecionada() {
        return catSelecionada;
    }

    public void setCatSelecionada(Categoria catSelecionada) {
        this.catSelecionada = catSelecionada;
    }

    public String jogar() {
        List<String> palavras = catSelecionada.getPalavras();
        int pos = rand.nextInt(palavras.size());
        sorteada = palavras.get(pos).toUpperCase();
        acertos = "";
        for (int i = 0; i < sorteada.length(); i++) {
            acertos += "_";

        }
        erros = 0;
        return null;
    }

    public String testarLetra() {

        String palavra = "";

        for (int i = 0; i < sorteada.length(); i++) {
            if (sorteada.charAt(i) == letra.charAt(0)) {
                palavra += letra.charAt(0);
            } else if (acertos.charAt(i) != '_') {
                palavra += sorteada.charAt(i);
            } else {
                palavra += "_";
            }
        }
        if (letras == null) {
            letras = letra;
        } else {
            letras += letra;
        }
        if (palavra.equals(acertos)) {
            if (erros <= 6) {
                erros++;
            } else {
                acertos = null;
                erros = 0;
                letras = null;
                sorteada = null;
                return null;
            }

        } else {
            acertos = palavra;
        }
        if (acertos.equals(sorteada)) {
            if (finalizadas == null) {
                finalizadas = acertos + ", ";
            } else {
                finalizadas += acertos + ", ";
            }
            acertos = null;
            erros = 0;
            letras = null;
            sorteada = null;
            return null;
        }
        return null;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public String getFinalizadas() {
        return finalizadas;
    }

    public void setFinalizadas(String finalizadas) {
        this.finalizadas = finalizadas;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra.toUpperCase();
    }

    public String getSorteada() {
        return sorteada;
    }

    public void setSorteada(String sorteada) {
        this.sorteada = sorteada;
    }

    public String getAcertos() {
        return acertos;
    }

    public void setAcertos(String acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public String contaErro() {
        switch (getErros()) {
            case 1 -> {
                return "1";
            }
            case 2 -> {
                return "2";
            }
            case 3 -> {
                return "3";
            }
            case 4 -> {
                return "4";
            }
            case 5 -> {
                return "5";
            }
            case 6 -> {
                derrotas++;
                return "6";
            }
            default -> {
                return "0";
            }
        }

    }

    public void setErros(int erros) {
        this.erros = erros;
    }

}
