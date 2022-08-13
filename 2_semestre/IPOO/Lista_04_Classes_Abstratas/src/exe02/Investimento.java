package exe02;
/*Uma conta de investimento tem como atributo a taxa de juros mensal que será paga (rendimento).*/
public class Investimento extends Conta{
	
	double rendimento;

	/**
	 * @param nome
	 * @param cPF
	 * @param dataAbertura
	 * @param saldo
	 * @param rendimento
	 */
	public Investimento(String nome, String cPF, String dataAbertura, double saldo, double rendimento) {
		super(nome, cPF, dataAbertura, saldo);
		this.rendimento = rendimento;
	}
	
	
	public void atualizar() {
		setSaldo(saldo * rendimento);
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	@Override
	public String toString() {
		return "Investimento - [rendimento: " + rendimento + ", numero: " + numero + ", nome: " + nome + ", CPF: " + CPF
				+ ", dataAbertura: " + dataAbertura + ", saldo: " + saldo + "]";
	}


	@Override
	public void atualizar(double taxa) {
		// TODO Auto-generated method stub
		
	}
	
	

}
