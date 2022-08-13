package exe03;

public class Comissionado extends Vendedor {
	
	 double totalVendas, comissao;
	
	public Comissionado(String nome, double salario, String setor, double vendas, double comissao) {
		super(nome, salario, setor);
		this.totalVendas = vendas;
		this.comissao = comissao;
	}


	public double getTotalVendas() {
		return totalVendas;
	}


	public double salarioVendedor() {
		return salarioLiquidoVendedor() + (totalVendas * comissao);
	}
	
	
	@Override
	public String toString() {
		return "\nComissionado \nTotal de vendas = " + totalVendas + "\nComiss�o = " + comissao + "Setor = " + setor + 
				"\nNome do funcion�rio = " + nome + "\nSal�rio = R$" + salarioVendedor();
	}
}
