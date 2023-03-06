package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Date;
import model.Consulta;
import model.TipoAnimal;
import model.Veterinario;

@Named(value = "consultaBean")
@SessionScoped
public class ConsultaBean implements Serializable {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction userTransaction;

    private Consulta consulta;
    private List<Consulta> consultas;

    // para filtar os veterinários quando o usuário alterar o tipo de animal a consultar
    private TipoAnimal tipoAnimal;
    private Veterinario veterinario;
    private Date quando;

    public Date getQuando() {
        return quando;
    }

    public void setQuando(Date quando) {
        this.quando = quando;
        consultas = null;
    }

    public ConsultaBean() {
        consulta = new Consulta();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
        consultas = null;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
        consultas = null;
    }

    public String salvar() {
        // TODO: completar o código para salvar a consulta, atualizando a lista.
        try {
            userTransaction.begin();
            consulta.setVeterinario(veterinario);
            consulta.setQuando((Date) quando);
            em.persist(consulta);
            userTransaction.commit();
            consulta = new Consulta();
            consultas = null;

        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException t) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException t2) {
            }
        }
        return null;
    }

    public String limpar() {
        consultas = null;
        quando = null;
        veterinario = null;
        return null;
    }

    public List<SelectItem> getVetsPorTipo() {
        if (tipoAnimal != null) {
            List<Veterinario> vets = em.createQuery("select v from "
                    + "Veterinario v where v.especialidade = :x")
                    .setParameter("x", tipoAnimal)
                    .getResultList();
            List<SelectItem> vetsPorTipo = new LinkedList<>();
            for (Veterinario v : vets) {
                vetsPorTipo.add(new SelectItem(v, v.getNome()));

            }
            return vetsPorTipo;
        } else {
            return new LinkedList<SelectItem>();
        }

    }

    public List<Consulta> getConsultas() {
        if (consultas != null) {
            return consultas;
        }
        if (veterinario == null && quando == null) {
            try {
                Query consulta = em.createQuery(
                        "select t from Consulta t "
                        + "order by t.quando",
                        Veterinario.class);
                consultas = consulta.getResultList();
            } catch (Throwable t) {
                consultas = new LinkedList<>();
            }
            return consultas;
        }
        if (quando != null && veterinario != null) {
            try {
                Date filtro;
                Date filtro2;
                filtro = (Date) quando.clone();
                filtro2 = (Date) filtro.clone();
                filtro.setHours(7);
                filtro2.setHours(23);
                
                Query consulta = em.createQuery(
                        "select c from Consulta c "
                        + "where c.veterinario = :x and c.quando BETWEEN :y AND :z ",
                        Veterinario.class)
                        .setParameter("x", this.veterinario)
                        .setParameter("y", filtro)
                        .setParameter("z", filtro2);
                consultas = consulta.getResultList();

            } catch (Throwable t) {
                consultas = new LinkedList<>();
            }
            return consultas;
        }
        if (quando == null && veterinario != null) {
            try {
                Query consulta = em.createQuery(
                        "select c from Consulta c "
                        + "where c.veterinario = :x ",
                        Veterinario.class)
                        .setParameter("x", this.veterinario);
                consultas = consulta.getResultList();
            } catch (Throwable t) {
                consultas = new LinkedList<>();
            }
            return consultas;
        } else {
            return null;
        }

    }

    public void remover(Consulta v) {
        try {
            userTransaction.begin();
            v = em.merge(v);
            em.remove(v);
            consultas.remove(v);
            userTransaction.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException t) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex2) {
            }
        }
    }
}
