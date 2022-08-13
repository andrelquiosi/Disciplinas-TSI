package heranca02;

public class ClientePJ extends Cliente {

	String razaoSocial, nomeFantasia, inscricaoEstadual, cnpj;

	/**
	 * @param email
	 * @param telefone
	 * @param endereco
	 * @param razaoSocial
	 * @param nomeFantasia
	 * @param inscricaoEstadual
	 * @param cnpj
	 */
	public ClientePJ(String email, String telefone, String endereco, String razaoSocial, String nomeFantasia,
			String inscricaoEstadual, String cnpj) {
		super(email, telefone, endereco);
		if (razaoSocial != null && nomeFantasia != null && inscricaoEstadual != null && cnpj != null) {
			this.razaoSocial = razaoSocial;
			this.nomeFantasia = nomeFantasia;
			this.inscricaoEstadual = inscricaoEstadual;
			this.cnpj = cnpj;
		}
	}

}
