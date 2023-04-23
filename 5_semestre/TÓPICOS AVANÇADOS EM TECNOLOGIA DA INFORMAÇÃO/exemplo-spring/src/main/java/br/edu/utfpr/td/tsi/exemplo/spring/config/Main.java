package br.edu.utfpr.td.tsi.exemplo.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
//@ComponentScan("br.edu.utfpr.td.tsi.exemplo.spring")
@ImportResource({ "classpath*:applicationContext.xml" })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Aplicação Spring iniciada");

	}

}
