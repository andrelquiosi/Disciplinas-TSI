package heranca02;

public class Cliente {
	String email, telefone, endereco;
	private int codigo;

	/**
	 * @param e-mail que possa ser utilizado para entrar em contato com o cliente
	 * @param telefone do cliente
	 * @param endereço em que o cliente possa ser encontrado
	 */
	public Cliente(String email, String telefone, String endereco) {
		if (codigo > 0 && email != null && telefone != null && endereco != null) {
			this.email = email;
			this.telefone = telefone;
			this.endereco = endereco;
			codigo++;
		}
		
	}

}
