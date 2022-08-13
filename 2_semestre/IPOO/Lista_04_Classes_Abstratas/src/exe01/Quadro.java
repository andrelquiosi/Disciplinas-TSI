package exe01;

import java.util.Arrays;

public class Quadro extends Obra {
	String estilo, tecnica;

	/**
	 * @param titulo
	 * @param autores
	 * @param anoLancamento
	 * @param estilo
	 * @param tecnica
	 */
	public Quadro(String titulo, String[] autores, String anoLancamento, String estilo, String tecnica) {
		super(titulo, autores, anoLancamento);
		this.estilo = estilo;
		this.tecnica = tecnica;
	}

	@Override
	public String toString() {
		return "Quadro - [estilo: " + estilo + ", tecnica: " + tecnica + ", titulo: " + titulo + ", autores: "
				+ Arrays.toString(autores) + ", anoLancamento: " + anoLancamento + "]";
	}

	
}
