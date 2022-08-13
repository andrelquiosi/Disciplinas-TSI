package questao2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Projeto {

	private String titulo;
	private Date inicio;
	private double valor;
	private ArrayList<Participacao> participacaoProjeto;

	/**
	 * @param titulo
	 * @param inicio
	 * @param valor
	 * @param participacaoProjeto
	 */
	public Projeto(String titulo, Date inicio, double valor) {
		super();
		this.titulo = titulo;
		this.inicio = inicio;
		this.valor = valor;
		participacaoProjeto = new ArrayList<Participacao>();
	}

	public void adicionarParticipacaoProjeto(Participacao p) {
		participacaoProjeto.add(p);
	}

	public ArrayList<Participacao> getParticipacaoProjeto() {
		return participacaoProjeto;
	}

	public static double calcularCusto(Programador prog) {

		ArrayList<Participacao> lista = new ArrayList<>();
		lista.addAll(prog.getParticipacaoProgramador());

		double custoProg = 0;
		double valor = 0;
		double hora = 0;

		for (int i = 0; i < lista.size(); i++) {
			hora = lista.get(i).getHoras();
			System.out.println(hora);
			valor = lista.get(i).getProgramador().getValorHora();
			System.out.println(valor);
			custoProg += (hora * valor);
		}
		return custoProg;
	}

	@Override
	public String toString() {
		return "Projeto - [titulo: " + titulo + ", inicio: " + inicio + ", valor: " + valor + ", participacaoProjeto: "
				+ participacaoProjeto + "]";
	}
}
