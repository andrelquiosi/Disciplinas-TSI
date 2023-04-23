package br.edu.utfpr.td.tsi.sistema.bancario.clientes.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dao.ClienteDAO;
import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.Cliente;
import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.DadosAcesso;

@Component
public class GerenciadorClientes implements RegrasClientes{
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public void cadastrar(Cliente cliente)  {
		System.out.println("Verificando dados do cliente");
		if(cliente.getRendaAnual() < 50000) {
			throw new RuntimeException("Renda anual insuficiente");
		}
		clienteDAO.gravar(cliente);
		System.out.println("Cliente cadastrado");
	}

	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente ler(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recuperarSenha(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarDadosAcesso(DadosAcesso dadosAcesso) {
		// TODO Auto-generated method stub
		
	}

}

