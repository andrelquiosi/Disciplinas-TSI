package heranca01;

public class Veiculo {

	public String placa;
	public int ano;

	/**
	 * @param placa
	 * @param ano
	 */
	public Veiculo(String placa, int ano) {
		if (placa != null && ano > 0) {
			this.placa = placa;
			this.ano = ano;
		}
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Veículo - Placa: " + placa + ", Ano: " + ano;
	}

}
