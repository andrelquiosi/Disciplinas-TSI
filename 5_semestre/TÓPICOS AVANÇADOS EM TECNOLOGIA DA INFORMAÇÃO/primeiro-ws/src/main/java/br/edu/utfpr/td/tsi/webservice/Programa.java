package br.edu.utfpr.td.tsi.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.webservice")
public class Programa {
	
	public static void main(String[] args) {
		SpringApplication.run(Programa.class, args);
	}

}
