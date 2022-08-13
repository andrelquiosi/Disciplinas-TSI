package questao1;

public class Servico implements ItemOrcamento {

	String nomePrestador;
	int hora;
	double valorHora;
	
	/**
	 * @param nomePrestador
	 * @param hora
	 * @param valorHora
	 */
	public Servico(String nomePrestador, int hora, double valorHora) {
		this.nomePrestador = nomePrestador;
		this.hora = hora;
		this.valorHora = valorHora;
	}

	@Override
	public String getDescricao() {
		return "Servico de " + nomePrestador;
	}

	@Override
	public double getValor() {
		return hora * valorHora;
	}

	@Override
	public String toString() {
		return "Servico - Nome do Prestador: " + nomePrestador + ", Horas de trabalho: " + hora + ", Valor da Hora: R$" + valorHora;
	}

	
}
