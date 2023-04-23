package br.edu.utfpr.td.tsi.sistema.bancario.clientes.negocio;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.Cliente;
import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.DadosAcesso;

public interface RegrasClientes {
	
	public void cadastrar(Cliente cliente);
	public void remover(String cpf);
	public void alterar(Cliente cliente);
	public Cliente ler(String cpf);
	public List<Cliente> listarTodosClientes();
	
	public void recuperarSenha(String cpf);
	public void alterarDadosAcesso(DadosAcesso dadosAcesso);
}

