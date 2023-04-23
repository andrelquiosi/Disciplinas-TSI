package br.edu.utfpr.td.tsi.sistema.bancario.clientes.dao;

import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.DadosAcesso;

public interface DadosAcessoDAO {
	
	public void gravar(DadosAcesso dadosAcesso);
	public void ler(String cpf);
	public void remover(String cpf);


}
