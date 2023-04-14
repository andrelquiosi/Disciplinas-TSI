package br.edu.utfpr.td.tsi.webservice.regras;

import br.edu.utfpr.td.tsi.webservice.controle.persistencia.PessoaDAOEmMemoria;
import br.edu.utfpr.td.tsi.webservice.modelo.Pessoa;

public class RegrasPessoaSP implements RegrasPessoa{

	@Override
	public void cadastrar(Pessoa pessoa) {
		if(pessoa.getIdade() > 9) {
			PessoaDAOEmMemoria persistencia = new PessoaDAOEmMemoria();
			persistencia.persistir(pessoa);
		}
		
	}

}
