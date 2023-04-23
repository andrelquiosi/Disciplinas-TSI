package br.edu.utfpr.td.tsi.exemplo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.exemplo.spring.dao.PessoaDAO;
import br.edu.utfpr.td.tsi.exemplo.spring.modelo.Pessoa;

@Component
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDAO pessoaDAO;

	@Override
	public void cadastrar(Pessoa p) {
		System.out.println("valindando regras serviceImpl");
		this.pessoaDAO.gravar(p);
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

}
