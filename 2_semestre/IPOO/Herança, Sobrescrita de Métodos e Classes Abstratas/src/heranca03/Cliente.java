package heranca03;

public class Cliente extends Parceiro {

	double limiteDeCredito;
	String rg, cpf;

	/**
	 * @param codigo
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param limiteDeCredito
	 * @param rg
	 * @param cpf
	 */
	public Cliente(String endereco, String telefone, String email, double limiteDeCredito, String rg,
			String cpf) {
		super(endereco, telefone, email);
		if (rg != null && cpf != null) {
			this.limiteDeCredito = limiteDeCredito;
			this.rg = rg;
			this.cpf = cpf;
		}
	}

}
