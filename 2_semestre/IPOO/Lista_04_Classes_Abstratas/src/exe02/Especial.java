package exe02;

/*Já uma conta especial é um tipo de conta corrente que tem um limite que pode ser sacado pelo cliente, 
 * além do seu saldo, e uma taxa de juros que será cobrada quando o limite for utilizado.*/
public class Especial extends Corrente {

	double limite, taxaDoLimite;

	/**
	 * @param nome
	 * @param cPF
	 * @param dataAbertura
	 * @param saldo
	 * @param limite
	 * @param taxaDoLimite
	 */
	public Especial(String nome, String cPF, String dataAbertura, double saldo, double limite,
			double taxaDoLimite) {
		super(nome, cPF, dataAbertura, saldo);
		this.limite = limite;
		this.taxaDoLimite = taxaDoLimite;
	}

	@Override
	public void atualizar(double taxa) {
		setSaldo(saldo - taxa);
	}

	public void saque(double saque) {
		if (saque > saldo) {
			double controle = saque - saldo;
			debito(saldo);
			usaLimite(controle);
		}else {
			debito(saque);
		}
			
	}
	private void usaLimite(double debitoLimite) {
		limite -= debitoLimite; 
	}

	@Override
	public String toString() {
		return "Especial - [limite: " + limite + ", taxaDoLimite: " + taxaDoLimite + ", numero: " + numero + ", nome: "
				+ nome + ", CPF: " + CPF + ", dataAbertura: " + dataAbertura + ", saldo: " + saldo + "]";
	}



}
