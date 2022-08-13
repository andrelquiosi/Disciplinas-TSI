package exe01;

public class TesteObras {

	public static void main(String[] args) {

		String[] autoresl1 = { "Marcos", "pedro" };
		Livro l1 = new Livro("Vida Livre", autoresl1, "2005", "14758", 254);

		String[] autoresf1 = { "Marcos", "pedro" };
		String[] atoresf1 = { "João", "Paulo", "Alex", "Filomena", "Nicolai", "Megan" };
		Filme f1 = new Filme("Vida Livre", autoresf1, "2017", 107, atoresf1);

		String[] autoresf2 = { "Marcos", "pedro" };
		String[] atoresf2 = { "João", "Alex", "Nicolai", "Megan", "Julia", "Marcela" };
		Filme f2 = new Filme("Vida Livre 2", autoresf2, "2019", 115, atoresf2);

		String[] autorq1 = { "Pedro" };
		Quadro q1 = new Quadro("Lima", autorq1, "1999", "Moderno", "Óleo sobre tela");

		String[] autore1 = { "Nicilai" };
		Escultura e1 = new Escultura("Dragões de Cera", autore1, "2000", "Argila clay", 150.5, 100, 78, 57);

		Obra[] obras = new Obra[] { l1, f1, f2, q1, e1 };
		
		//FOLTRA POR TIPO
		for (Obra s : obras) {
			if (s instanceof Filme) {
				System.out.println(s.toString());
			}
		}

		// FILTRA POR ANO DELANÇAMENTO
		String anoDeLancamento = "2019";
		for (Obra s : obras) {
			if (s.getAnoLancamento().equals(anoDeLancamento)) {
				System.out.println(s.toString());
			}
		}
		
		// FILTRA POR AUTOR
		String autor = "Nicolai";
		for (Obra s : obras) {
			for (int i = 0; i < s.getAutores().length; i++) {
				if(s.autores[i].equals(autor)) {
					System.out.println(s.toString());
					
				}
			}

		}

	}

}
