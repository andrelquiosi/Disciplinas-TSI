package exe01;

import java.util.Arrays;

public class Escultura extends Obra{
	
	String material;
	double altura, largura, comprimento;
	double peso;
	
	/**
	 * @param titulo
	 * @param autores
	 * @param anoLancamento
	 * @param material
	 * @param altura
	 * @param larfura
	 * @param comprimento
	 * @param peso
	 */
	
	public Escultura(String titulo, String[] autores, String anoLancamento, String material, double altura,
			double largura, double comprimento, double peso) {
		super(titulo, autores, anoLancamento);
		this.material = material;
		this.altura = altura;
		this.largura = largura;
		this.comprimento = comprimento;
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Escultura - [material: " + material + ", altura: " + altura + ", largura: " + largura
				+ ", comprimento: " + comprimento + ", peso: " + peso + ", titulo: " + titulo + ", autores: "
				+ Arrays.toString(autores) + ", anoLancamento: " + anoLancamento + "]";
	}


	
	
	
	
}
