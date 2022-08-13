package exe01;

import java.util.Arrays;

public class Livro extends Obra {

	String codigoISBN;
	int paginas;

	/**
	 * @param titulo
	 * @param autores
	 * @param anoLancamento
	 * @param codigoISBN
	 * @param paginas
	 */
	public Livro(String titulo, String[] autores, String anoLancamento, String codigoISBN, int paginas) {
		super(titulo, autores, anoLancamento);
		this.codigoISBN = codigoISBN;
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Livro - [codigoISBN: " + codigoISBN + ", paginas: " + paginas + ", titulo: " + titulo + ", autores: "
				+ Arrays.toString(autores) + ", anoLancamento: " + anoLancamento + "]";
	}
	
	

}
