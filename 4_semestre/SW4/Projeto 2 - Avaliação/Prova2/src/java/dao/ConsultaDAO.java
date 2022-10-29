/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidade.Consulta;
import java.io.Serializable;
import java.util.ArrayList;

public class ConsultaDAO implements Serializable {

    private final ArrayList<Consulta> consultas;

    public ConsultaDAO() {
        consultas =new ArrayList<>();
    }

    public void incluir(Consulta a) throws ConsultaJaCadastrado {
        if (consultas.contains(a)) {
            throw new ConsultaJaCadastrado();
        }
        consultas.add(a);
    }

    public void remover(Consulta a) {

        consultas.remove(a);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

}
