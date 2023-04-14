package br.edu.utfpr.td.tsi.sistema.bancario;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/banco")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		this.register(RequestContextFilter.class);
		this.packages(" br.edu.utfpr.td.tsi.sistema.bancario.endpoint");
	}
}