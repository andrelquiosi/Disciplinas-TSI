package br.edu.utfpr.td.tsi.exemplo.spring.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.exemplo.spring.modelo.Pessoa;

@Component
public class RDBPessoaDAO implements PessoaDAO {

	@Override
	public void gravar(Pessoa p) {
		System.out.println("Gravando pessoa em RDB");
	}

}
