package br.com.aula16.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import br.com.aula16.loja.dao.ProdutoDao;
import br.com.aula16.loja.modelo.Categoria;
import br.com.aula16.loja.modelo.Produto;
import br.com.aula16.loja.util.JPAUtil;

public class CadastroDeProduto {

    public static void main(String[] args) throws Exception {

        Produto celular = new Produto("Android", "Trincado", new BigDecimal("200"), Categoria.CELULARES);
        Produto celular2 = new Produto("IPhone", "Trincado", new BigDecimal("750"), Categoria.CELULARES);
        Produto livro = new Produto(" A Menina que roubava livros", "Capa dura", new BigDecimal("60"), Categoria.LIVROS);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        // inicia a transação
        em.getTransaction().begin();

        //cadastraod produtos
        dao.cadastrar(celular);
        dao.cadastrar(celular2);
        dao.cadastrar(livro);

        //realiza a transação de inserção no banco
        em.getTransaction().commit();

        //mostra as inserções
        dao.ler();

        //altera o valor do celular 
        celular.setPreco(new BigDecimal("500"));
        celular = dao.salvar(celular);

        //mostra as inserções
        dao.ler();

        //exclui o celular 2
        dao.excluir(celular2.getId());

        //mostra as inserções
        dao.ler();
        
        //fecha a conecção com o banco
        em.close();

    }

}
