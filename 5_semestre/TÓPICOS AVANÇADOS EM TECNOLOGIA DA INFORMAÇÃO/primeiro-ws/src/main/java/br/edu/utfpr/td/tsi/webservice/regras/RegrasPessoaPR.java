package br.edu.utfpr.td.tsi.webservice.regras;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.PessoaDAO;
import br.edu.utfpr.td.tsi.webservice.controle.persistencia.PessoaDAOEmMemoria;
import br.edu.utfpr.td.tsi.webservice.modelo.Pessoa;

@Component
public class RegrasPessoaPR  implements RegrasPessoa{
	
	@Autowired
	private PessoaDAO pessoaDAO;

	public void cadastrar(Pessoa p) {
		//PR
		if(p.getIdade() > 17) {			
			pessoaDAO.persistir(p);
		}		
	}

	
	
	//implentar as regras

}
