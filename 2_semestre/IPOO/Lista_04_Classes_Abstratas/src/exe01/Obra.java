package exe01;

import java.util.Arrays;

public abstract class Obra {

	String titulo;
	String[] autores = new String[5];
	String anoLancamento;

	/**
	 * @param titulo
	 * @param autores
	 * @param anoLancamento
	 */
	public Obra(String titulo, String[] autores, String anoLancamento) {
		if (autores.length <= this.autores.length) {
			this.titulo = titulo;
			this.autores = autores;
			this.anoLancamento = anoLancamento;
		}
	}

	public String[] getAutores() {
		return autores;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}
}

///instance of
