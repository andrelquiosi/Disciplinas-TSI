package heranca01;

public class Onibus extends Veiculo {

	int assentos;

	/**
	 * @param placa
	 * @param ano
	 * @param assentos
	 */
	public Onibus(String placa, int ano, int assentos) {
		super(placa, ano);
		this.assentos = assentos;
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		if (assentos > 0)
			this.assentos = assentos;
	}

	@Override
	public String toString() {
		return "Onibus - Assentos: " + assentos + ". Placa: " + placa + ". Ano: " + ano;
	}

}
