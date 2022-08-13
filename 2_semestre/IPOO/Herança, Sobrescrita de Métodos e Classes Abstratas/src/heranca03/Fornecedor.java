package heranca03;

public class Fornecedor extends Parceiro {

	boolean desconto;
	String razaoSocial, nomeFantasia, inscricaoEstadual, cnpj;

	/**
	 * @param codigo
	 * @param endereco
	 * @param telefone
	 * @param email
	 * @param razaoSocial
	 * @param nomeFantasia
	 * @param inscricaoEstadual
	 * @param cnpj
	 */
	public Fornecedor(String endereco, String telefone, String email, double desconto, String razaoSocial,
			String nomeFantasia, String inscricaoEstadual, String cnpj) {
		super(endereco, telefone, email);
		if (razaoSocial != null && nomeFantasia != null && inscricaoEstadual != null && cnpj != null) {
			this.razaoSocial = razaoSocial;
			this.nomeFantasia = nomeFantasia;
			this.inscricaoEstadual = inscricaoEstadual;
			this.cnpj = cnpj;
		}
	}

	public boolean getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		if (desconto == "Sim")
			this.desconto = true;
		else if(desconto == "Não")
			this.desconto = false;
	}

}
