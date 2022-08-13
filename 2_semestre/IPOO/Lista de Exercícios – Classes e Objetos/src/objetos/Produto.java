package objetos;

public class Produto {

	private String nome;
	private int estoque;
	private double precoUnitario;
	private static int codigo;

	public Produto(String nome) {
		if (nome != null) {
			this.nome = nome;
			this.codigo = codigo +1;
		}
	}

	public Produto(String nome, double precoUnitario) {
		if (nome != null) {
			this.nome = nome;
			this.precoUnitario = precoUnitario;
			this.codigo = codigo +1;
		}
	}

	public void setEntradas(int estoque, double precoUnitario) {
		if (estoque > 0 && precoUnitario > 0) {
			this.estoque = estoque;
			this.precoUnitario = precoUnitario;
		}
	}

	public void setSaidas(int quantidade) {
		if (quantidade > 0 && quantidade <= estoque) {
			this.estoque = estoque - quantidade;
		}

	}
	
	public void setPrecoUnitario(double precoUnitario) {
		if (precoUnitario > 0) {
		this.precoUnitario = precoUnitario;
		}
	}

	@Override
	public String toString() {
		return "Produto"+ codigo+" [nome=" + nome + ", estoque=" + estoque + ", precoUnitario=" + precoUnitario + "]";
	}



}
