package exe02;

/*Uma conta corrente tem uma taxa mensal de manutenção, 
 *e permite débitos apenas enquanto houver saldo suficiente.*/
public class Corrente extends Conta {

	protected Corrente(String nome, String cPF, String dataAbertura, double saldo) {
		super(nome, cPF, dataAbertura, saldo);
	}

	@Override
	public void atualizar(double taxa) {
		if (saldo > taxa)
			setSaldo(saldo - taxa);
	}

	public void debito(double debito) {
		if (saldo >= debito)
			setSaldo(saldo - debito);
	}

	@Override
	public String toString() {
		return "Corrente - [numero: " + numero + ", nome: " + nome + ", CPF: " + CPF + ", dataAbertura: " + dataAbertura
				+ ", saldo: " + saldo + "]";
	}

}
