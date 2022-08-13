package programas;

import java.util.Date;

import questao2.Participacao;
import questao2.Programador;
import questao2.Projeto;

public class Questao2 {

	public static void main(String[] args) {

		Programador prog = new Programador("123.654.789.20", "Andre", 450.00);
		Projeto proj = new Projeto("Loja", new Date(), 200000.00);

		Participacao part1 = new Participacao(20, new Date(), "front");
		Participacao part2 = new Participacao(30, new Date(), "JS");
		Participacao part3 = new Participacao(40, new Date(), "Android");

		prog.adicionarParticipacao(part1);
		prog.adicionarParticipacao(part3);
		
		part1.setProgramador(prog);
		
		proj.adicionarParticipacaoProjeto(part1);
		proj.adicionarParticipacaoProjeto(part2);
		proj.adicionarParticipacaoProjeto(part3);		

		System.out.println(prog.getParticipacaoProgramador().toString());
		System.out.println(Projeto.calcularCusto(prog));

	}

}
