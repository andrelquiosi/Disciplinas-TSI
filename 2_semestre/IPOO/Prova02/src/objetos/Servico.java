package objetos;

public class Servico {

	private String descricao;
	private int tempoContratado, tempoTrabalhado;
	private double precoHora, taxaHoraAdicional;
	private boolean ativo;

	/**
	 * @param descricao
	 * @param tempoContratado
	 * @param precoHora
	 * @param taxaHoraAdicional
	 */
	public Servico(String descricao, int tempoContratado, double precoHora, double taxaHoraAdicional) {
		if (descricao != null && tempoContratado > 0 && precoHora > 0 && taxaHoraAdicional > 0) {
			this.descricao = descricao;
			this.tempoContratado = tempoContratado;
			this.precoHora = precoHora;
			this.taxaHoraAdicional = taxaHoraAdicional;
			this.ativo = true;
		}
	}

	/**
	 * 
	 * @param tempoTrabalhado
	 */
	public double registrar(int tempoTrabalhado) {
		if (tempoTrabalhado > 0 && ativo == true) {
			this.tempoTrabalhado += tempoTrabalhado;
			calculaPagamento();
		}
		return tempoTrabalhado;
	}

	public void encerrar() {
		this.ativo = false;
	}

	private double calculaPagamento() {

		if ((tempoContratado - tempoTrabalhado) < 0) {

			return ((tempoTrabalhado * precoHora) + ((tempoTrabalhado - tempoContratado) * taxaHoraAdicional));

		} else {
			return (tempoTrabalhado * precoHora);
			
		}
	}

	public int getSaldoHoras() {
		return tempoContratado - tempoTrabalhado;

	}

	@Override
	public String toString() {
		return "Servico - [descricao: " + descricao + ", tempoContratado: " + tempoContratado + ", tempoTrabalhado: "
				+ tempoTrabalhado + ", precoHora: " + precoHora + ", taxaHoraAdicional: " + taxaHoraAdicional
				+ ", ativo: " + ativo + ", calculaPagamento(): " + calculaPagamento() + "]";
	}





}
