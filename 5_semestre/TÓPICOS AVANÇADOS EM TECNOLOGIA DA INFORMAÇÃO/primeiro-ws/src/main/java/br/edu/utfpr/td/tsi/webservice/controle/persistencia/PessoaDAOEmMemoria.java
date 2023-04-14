package br.edu.utfpr.td.tsi.webservice.controle.persistencia;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.Pessoa;

@Component
public class PessoaDAOEmMemoria implements PessoaDAO{
	
	private ArrayList<Pessoa> bd = new ArrayList<>();

	public void persistir(Pessoa p) {
		bd.add(p);
		System.out.println("pessoa salva no banco de dados");
		System.out.println(p.getIdade());
		
	}

	@Override
	public Pessoa procurar(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//implentar a persistrncia

}
