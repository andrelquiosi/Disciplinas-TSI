package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import br.edu.utfpr.td.tsi.webservice.modelo.Pessoa;

public interface PessoaDAO {
	
	public void persistir(Pessoa p);
	
	public Pessoa procurar(String email);

}
