package objetos;

public class Insumo {

	public int codigo;
	public String descricao;
	public double preco;

	/**
	 * @param codigo
	 * @param descricao
	 * @param preco
	 */

	public Insumo(int codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double calcularImpostos() {
		return (preco * 0.07) + (preco * 0.08);
	}

	public double calcularCustoTotal() {
		return calcularImpostos() + preco;
	}
	
	////////////////////////////get and set/////////////////////////////////

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/////////////////////////////////////////////

}
