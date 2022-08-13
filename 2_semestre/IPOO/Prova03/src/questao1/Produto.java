package questao1;

public class Produto implements ItemOrcamento {
	
	String descricao;
	double valorUnitario;
	int quantidade;

	/**
	 * @param quantidade
	 * @param valorUnitario
	 * @param descricao
	 */
	public Produto(String descricao, double valorUnitario,int quantidade) {
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.descricao = descricao;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public double getValor() {
		return quantidade * valorUnitario;
	}

	@Override
	public String toString() {
		return "Produto - Descricao: " + descricao + ", Valor unitario: R$" + valorUnitario + ", Quantidade: "
				+ quantidade;
	}


	
	

}
