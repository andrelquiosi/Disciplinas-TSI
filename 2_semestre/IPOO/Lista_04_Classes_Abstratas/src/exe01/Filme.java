package exe01;

import java.util.Arrays;

public class Filme extends Obra {

	int duracao;
	String[] atores = new String[20];

	/**
	 * @param titulo
	 * @param autores
	 * @param anoLancamento
	 * @param duracao
	 * @param atores
	 */
	public Filme(String titulo, String[] autores, String anoLancamento, int duracao, String[] atores) {
		super(titulo, autores, anoLancamento);
		if (atores.length <= this.atores.length) {
			this.duracao = duracao;
			this.atores = atores;
		}
	}

	@Override
	public String toString() {
		return "Filme - [duracao: " + duracao + ", atores: " + Arrays.toString(atores) + ", titulo: " + titulo
				+ ", autores: " + Arrays.toString(autores) + ", anoLancamento: " + anoLancamento + "]";
	}
	
	

}
