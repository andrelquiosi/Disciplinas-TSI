package heranca03;

public class Parceiro {

	int codigo;
	String endereco, telefone, email;

	/**
	 * @param codigo
	 * @param endereco
	 * @param telefone
	 * @param email
	 */
	public Parceiro(String endereco, String telefone, String email) {
		if (codigo > 0 && email != null && telefone != null && endereco != null) {
			this.endereco = endereco;
			this.telefone = telefone;
			this.email = email;
			codigo++;
		}
	}


}
