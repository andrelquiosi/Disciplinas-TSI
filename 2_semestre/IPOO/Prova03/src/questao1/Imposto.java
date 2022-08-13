package questao1;

public class Imposto implements ItemOrcamento{
	
	String fatoGerador;
	double baseCalculo, aliquota;
	
	/**
	 * @param fatoGerador
	 * @param baseCalculo
	 * @param aliquota
	 */
	public Imposto(String fatoGerador, double baseCalculo, double aliquota) {
		this.fatoGerador = fatoGerador;
		this.baseCalculo = baseCalculo;
		this.aliquota = aliquota;
	}
	@Override
	public String getDescricao() {
		return fatoGerador;
	}
	@Override
	public double getValor() {
		return (baseCalculo * (aliquota/100)) + baseCalculo;
	}
	@Override
	public String toString() {
		return "Imposto - Fator Gerador: " + fatoGerador + ", Base de Calculo: R$" + baseCalculo + ", Aliquota: " + aliquota
				+ "%";
	}
	
	
	
	

}
