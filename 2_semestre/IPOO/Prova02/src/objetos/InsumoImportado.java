package objetos;

public class InsumoImportado extends Insumo {

	static double COTACAO_DOLAR;
	 double taxaImportacao;
	 String paisOrigem;

	/**
	 * @param codigo
	 * @param descricao
	 * @param preco
	 * @param taxaImportacao
	 * @param paisOrigem
	 */
	public InsumoImportado(int codigo, String descricao, double preco, double taxaImportacao, String paisOrigem) {
		super(codigo, descricao, preco);
		this.taxaImportacao = taxaImportacao;
		this.paisOrigem = paisOrigem;
	}

	public double calcularImpostos() {	
		return (taxaImportacao * COTACAO_DOLAR) + ((preco * COTACAO_DOLAR)* 0.08);
	}

	public double calcularCustoTotal() {
		return calcularImpostos() + (preco* COTACAO_DOLAR);
	}

	public static void setCotacaoDolar(double COTACAO) {
		COTACAO_DOLAR = COTACAO;
	}

}
