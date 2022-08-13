package heranca01;

public class Caminhao extends Veiculo {

	int eixos;

	/**
	 * @param placa
	 * @param ano
	 * @param eixos
	 */
	public Caminhao(String placa, int ano, int eixos) {
		super(placa, ano);
		this.eixos = eixos;
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}

	@Override
	public String toString() {
		return "subclasse = Caminhão - Eixos: " + eixos + ".\n superclasse = Placa: " + placa + ". Ano: " + ano;
	}

}
