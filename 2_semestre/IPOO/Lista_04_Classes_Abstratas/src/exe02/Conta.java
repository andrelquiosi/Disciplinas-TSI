package exe02;

//. Cada conta tem um número, o nome e o CPF do titular, a data de abertura e um saldo.
public abstract class Conta {

	int numero;
	String nome, CPF, dataAbertura;
	double saldo;

	/**
	 * @param numero
	 * @param nome
	 * @param cPF
	 * @param dataAbertura
	 * @param saldo
	 */
	protected Conta(String nome, String cPF, String dataAbertura, double saldo) {
		numero += 1;
		this.nome = nome;
		CPF = cPF;
		this.dataAbertura = dataAbertura;
		this.saldo = saldo;
	}

	protected void setSaldo(double saldo) {
		if (saldo > 0)
			this.saldo += saldo;
		
	}

	public String getCPF() {
		return CPF;
	}

	public abstract void atualizar(double taxa);

}
