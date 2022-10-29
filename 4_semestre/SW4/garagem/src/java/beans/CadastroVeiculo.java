package beans;

import dao.MarcaDAO;
import dao.VeiculoDAO;
import dao.VeiculoJaCadastrado;
import entidade.Marca;
import entidade.Modelo;
import entidade.Veiculo;
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

@Named(value = "cadastroVeiculo")
@SessionScoped
public class CadastroVeiculo implements Serializable {

    @Inject
    MarcaDAO marcaDAO;
    
    @Inject
    VeiculoDAO veiculoDAO;
  
    private ArrayList<Veiculo> filtrados;
    private Veiculo veiculo;
    private boolean editando = false;
    private Marca marcaEscolhida, marcaFiltro;
    int anoInicio, anoFim;

    public CadastroVeiculo() {
    }

    public Marca getMarcaEscolhida() {
        return marcaEscolhida;
    }
    
    public List<SelectItem> getMarcasItens() {
        return marcaDAO.getMarcasItens();
    }

    public void setMarcaEscolhida(Marca marcaEscolhida) {
        this.marcaEscolhida = marcaEscolhida;
    }

    @PostConstruct
    public void init() {        
        // Neste ponto, os daos já foram injetados. Poderiam ser usados.
        veiculo = new Veiculo();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String confirmar() {
        if (!editando) {
            try {
                veiculoDAO.incluir(veiculo);
            } catch(VeiculoJaCadastrado vjc) {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage("Placa já cadastrada!"));
            }
        }
        editando = false;
        veiculo = new Veiculo();
        filtrar();
        return null;
    }

    public void remover(Veiculo veic) {
        veiculoDAO.remover(veic);
        filtrados.remove(veic);
    }

    public void editar(Veiculo v) {
        veiculo = v;
        editando = true;
    }

    public String cancelar() {
        editando = false;
        veiculo = new Veiculo();
        return null;
    }

    public List<SelectItem> getModelosItens() {
        if (marcaEscolhida == null) {
            return new LinkedList<>();
        }
        LinkedList<SelectItem> itens = new LinkedList<>();
        itens.add(new SelectItem(null, "Selecione o modelo"));
        for (Modelo mod : marcaEscolhida.getModelos()) {
            itens.add(new SelectItem(mod, mod.getNome()));
        }
        return itens;
    }

    public ArrayList<Veiculo> getFiltrados() {
        return filtrados;
    }

    public void setFiltrados(ArrayList<Veiculo> filtrados) {
        this.filtrados = filtrados;
    }

    public Marca getMarcaFiltro() {
        return marcaFiltro;
    }

    public void setMarcaFiltro(Marca marcaFiltro) {
        this.marcaFiltro = marcaFiltro;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public int getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(int anoFim) {
        this.anoFim = anoFim;
    }

    public String filtrar() {
        filtrados = veiculoDAO.buscar(marcaFiltro, anoInicio, anoFim);
        return null;
    }
}
