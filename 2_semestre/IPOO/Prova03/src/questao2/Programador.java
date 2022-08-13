package questao2;

import java.util.ArrayList;

public class Programador {

	private String CPF, nome;
	private double valorHora;
	private ArrayList<Participacao> participacaoProgramador;

	/**
	 * @param cPF
	 * @param nome
	 * @param valorHora
	 * @param participacaoProjeto
	 */
	public Programador(String cPF, String nome, double valorHora) {
		super();
		CPF = cPF;
		this.nome = nome;
		this.valorHora = valorHora;
		participacaoProgramador = new ArrayList<Participacao>();

	}

	public String getCPF() {
		return CPF;
	}

	public String getNome() {
		return nome;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void adicionarParticipacao(Participacao p) {
		participacaoProgramador.add(p);
	}

	public ArrayList<Participacao> getParticipacaoProgramador() {
		return participacaoProgramador;
	}

	@Override
	public String toString() {
		return "Programador - [CPF: " + CPF + ", nome: " + nome + ", valorHora: " + valorHora
				+ ", participacaoProgramador: " + participacaoProgramador + "]";
	}

}
