package br.edu.utfpr.td.tsi.webservice.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.Pessoa;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasPessoa;

@Component
public class ControlePessoa {
	
	@Autowired
	private RegrasPessoa regraPessoa;
	
	public void redirecionarNovoCadastro(Pessoa p) {		
		regraPessoa.cadastrar(p);		
	}

}
