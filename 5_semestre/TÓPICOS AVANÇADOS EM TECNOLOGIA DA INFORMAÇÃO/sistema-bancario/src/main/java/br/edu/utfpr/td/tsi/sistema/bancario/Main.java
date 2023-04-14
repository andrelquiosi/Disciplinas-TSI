package br.edu.utfpr.td.tsi.sistema.bancario;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.Cliente;
import br.edu.utfpr.td.tsi.sistema.bancario.clientes.negocio.RegrasClientes;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.sistema.bancario")
public class Main {
	
	@Autowired
	private RegrasClientes regrasClientes;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);			
	}
	
	@PostConstruct
	public void inicio(){
		//aqui começa a aplicação Spring
		Cliente cliente = new Cliente();
		cliente.setCpf("1234");
		cliente.setDataNascimento("10/10/2000");
		cliente.setNome("joao silva");
		cliente.setEmail("joao@silva.com");
		cliente.setRendaAnual(50000);
		
		regrasClientes.cadastrar(cliente);	
	}
}

