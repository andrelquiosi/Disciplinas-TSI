package br.edu.utfpr.td.tsi.exemplo.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.exemplo.spring.service.PessoaService;
import jakarta.annotation.PostConstruct;

@Component
public class Executor {

	@Autowired
	private PessoaService pessoaService;

	@PostConstruct
	public void iniciarPrograma() {
		pessoaService.cadastrar(null);
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
}
