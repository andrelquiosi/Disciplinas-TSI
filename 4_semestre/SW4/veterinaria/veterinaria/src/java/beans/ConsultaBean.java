package beans;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Consulta;
import model.TipoAnimal;
import model.Veterinario;


@Named(value = "consultaBean")
@SessionScoped
public class ConsultaBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    private Consulta consulta;
    
    // para filtar os veterinários quando o usuário alterar o tipo de animal a consultar
    private TipoAnimal tipoAnimal;
    
    public ConsultaBean() {
        consulta = new Consulta();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    public String salvar() {
        // TODO: completar o código para salvar a consulta, atualizando a lista.
        return null;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    
    public List<SelectItem> getVetsPorTipo(){
        List<Veterinario> vets = em.createQuery("select v from "+
                "Veterinario v where v.especialidade = :x").setParameter("x", tipoAnimal).
                getResultList();
    }
    
    
}
