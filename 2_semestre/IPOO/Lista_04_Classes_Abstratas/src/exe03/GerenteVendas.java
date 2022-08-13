package exe03;

public class GerenteVendas extends Gerente {
	double comissao, totalVendas;

	public GerenteVendas(String nome, double comissao, double totalVendas) {
		super(nome);
		this.comissao = comissao;
		this.totalVendas = totalVendas;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public double salarioGerenteVendas() {
		return (totalVendas * comissao);
	}

	@Override
	public String toString() {
		return "\nGerente de Vendas \nTotal de vendas = " + totalVendas + "\nComissão = " + comissao
				+ "\nNome do funcionário = " + nome + "\nSalário = R$" + salarioGerenteVendas();
	}

}
