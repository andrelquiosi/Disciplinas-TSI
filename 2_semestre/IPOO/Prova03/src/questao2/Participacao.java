package questao2;

import java.util.Date;

public class Participacao {
	
	private int horas;
	private Date inicio;
	private String atribuicao;
	private Programador programador;
	private Projeto projeto;
	
	public Participacao(int horas, Date inicio, String atribuicao) {
		super();
		this.horas = horas;
		this.inicio = inicio;
		this.atribuicao = atribuicao;		
	}

	public void setProgramador(Programador programador) {
		this.programador = programador;
	}

	public Programador getProgramador() {
		return programador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public int getHoras() {
		return horas;
	}

	public Date getInicio() {
		return inicio;
	}

	public String getAtribuicao() {
		return atribuicao;
	}

	@Override
	public String toString() {
		return "Participacao - [horas: " + horas + ", inicio: " + inicio + ", atribuicao: " + atribuicao
				+ ", programador: " + getProgramador();
	}
}
