package heranca02;

public class ClientePF extends Cliente {

	String nome, rg, cpf;

	/**
	 * @param email
	 * @param telefone
	 * @param endereco
	 * @param nome
	 * @param rg
	 * @param cpf
	 */
	public ClientePF(String email, String telefone, String endereco, String nome, String rg, String cpf) {
		super(email, telefone, endereco);
		if (nome != null && rg != null && cpf != null) {
			this.nome = nome;
			this.rg = rg;
			this.cpf = cpf;
		}
	}

}
