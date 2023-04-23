package br.edu.utfpr.td.tsi.sistema.bancario.clientes.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.Cliente;

public interface ClienteDAO {
	
	public void gravar(Cliente cliente);
	public Cliente ler(String cpf);
	public void remover(String cpf);
	public List<Cliente> lerTodos();
}

