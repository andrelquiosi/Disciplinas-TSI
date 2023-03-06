package br.com.aula16.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import br.com.aula16.loja.dao.ProdutoDao;
import br.com.aula16.loja.modelo.Categoria;
import br.com.aula16.loja.modelo.Produto;
import br.com.aula16.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		
		Produto celular = new Produto("Android", "Trincado", new BigDecimal("200"), Categoria.CELULARES);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em); 
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	
	}

}
