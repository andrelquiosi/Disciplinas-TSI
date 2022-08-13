package heranca03;

public class Funcionario extends Parceiro {

	String numeroCTPS, serieCTPS, rg;

	/**
	 * @param codigo
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param numeroCTPS
	 * @param serieCTPS
	 * @param rg
	 */
	public Funcionario(String endereco, String telefone, String email, String numeroCTPS, String serieCTPS, String rg) {
		super(endereco, telefone, email);
		if (serieCTPS != null && numeroCTPS != null && rg != null) {
			this.numeroCTPS = numeroCTPS;
			this.serieCTPS = serieCTPS;
			this.rg = rg;
		}
	}

}
