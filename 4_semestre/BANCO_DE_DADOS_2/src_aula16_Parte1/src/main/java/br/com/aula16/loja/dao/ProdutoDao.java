package br.com.aula16.loja.dao;

import javax.persistence.EntityManager;
import br.com.aula16.loja.modelo.Produto;
import java.util.List;
import javax.persistence.Query;

public class ProdutoDao {

    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto p) {
        this.em.persist(p);
    }

    public void ler() {
        Query query = em.createQuery("SELECT p from Produto p ");
        List<Produto> lista = query.getResultList();

        lista.forEach((Produto produto) -> {
            System.out.printf("Produto: %s\n"
                    + "Descrição: %s\n"
                    + "Preço: R$%s\n"
                    + "Categoria: %s\n\n",
                    produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getCategoria());
        });

    }

    public void excluir(Long id) {

        // Inicia uma transação com o banco de dados.
        em.getTransaction().begin();
        /* Consulta na base de dados através 
        do seu ID. */
        Produto produto = consultarPorId(id);
        System.out.println("Excluindo produto: "
                + produto.getNome());

        // Remove  da base de dados.
        em.remove(produto);
        // Finaliza a transação.
        em.getTransaction().commit();

    }

    public Produto consultarPorId(Long id) {
        Produto produto = null;
        produto = em.find(Produto.class, id);

        return produto;
    }

    public Produto salvar(Produto produto) throws Exception {

        // Inicia uma transação com o banco de dados.
        em.getTransaction().begin();
        System.out.println("Salvando produto.");
        /* Verifica se ainda não está salva 
        no banco de dados. */
        if (produto.getId() == null) {
            em.persist(produto);
        } else {
            produto = em.merge(produto);
        }
        // Finaliza a transação.
        em.getTransaction().commit();

        return produto;
    }
}
