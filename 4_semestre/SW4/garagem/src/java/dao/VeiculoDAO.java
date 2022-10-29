package dao;

import entidade.Marca;
import entidade.Veiculo;
import java.io.Serializable;
import java.util.ArrayList;

public class VeiculoDAO implements Serializable {
    private ArrayList<Veiculo> veiculos;
    
    public VeiculoDAO() {
        veiculos = new ArrayList<>();
    }
    
    public void incluir(Veiculo v) throws VeiculoJaCadastrado {
        if (veiculos.contains(v)) {
            throw new VeiculoJaCadastrado();
        }
        veiculos.add(v);
    }
    
    public ArrayList<Veiculo> buscar(Marca marcaFiltro, int anoInicio, int anoFim) {
        ArrayList<Veiculo> filtrados = new ArrayList<>();
        if (marcaFiltro == null) {
            filtrados.addAll( veiculos );
        } else {
            for (Veiculo v : veiculos) {
                if (v.getModelo().getMarca().equals(marcaFiltro)) {
                    filtrados.add(v);
                }
            }
        }
        if (anoInicio > 0 && anoFim > 0) {
            ArrayList<Veiculo> filtroAnos = new ArrayList<>();
            for (Veiculo v : filtrados) {
                if (v.getAnoFabricacao() >= anoInicio && v.getAnoFabricacao() <= anoFim) {
                    filtroAnos.add(v);
                }
            }
            filtrados = filtroAnos;
        }
        return filtrados;
    }
    
    public void remover(Veiculo v) {
        veiculos.remove(v);
    }
    
}
