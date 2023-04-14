package br.edu.utfpr.td.tsi.sistema.bancario.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.utfpr.td.tsi.sistema.bancario.clientes.dominio.Cliente;


@Path("teste")
public class TesteEndPoint {
	@GET 
	public Response teste() {
		return Response.ok("Teste bem sucedido").build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho2/{var1}")
	public Response teste2(@PathParam("var1") String x){
	return Response.ok(String.format("%s foi informado como pathParam", x)).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho3")
	public Response teste3(@QueryParam("var2") String x){
		return Response.ok(String.format("%s foi informado como queryParam", x)).build();
	}
	
	@PathParam("var1") 
	private String x;
	
	@QueryParam("var2") 
	private String y;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("caminho4")	
	public Response teste4(){
		return Response.ok(String.format("%s = pathParan %s = queryParam ", x, y)).build();
	}
	
	@GET
	@Path("/carregarCliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Response carregarCliente() {
		Cliente cliente = new Cliente();
		cliente.setEmail("joao@silva.com");
		cliente.setNome("Joao da Silva");
		cliente.setDataNascimento("10/10/2000");
		
		return Response.ok(cliente).build();
	}
	
}

