package program;

import java.util.*;

public class EX1 {

	public static void main(String[] args) throws Exception {

		ArrayList<Livro> biblioteca = new ArrayList<>();

        biblioteca.add(new Livro("src/livros/dracula_by_BramStoker.txt"));
//        biblioteca.add(new Livro("src/livros/1914_by_John_Oxenham.txt"));
//		biblioteca.add(new Livro("src/livros/A_Lecture_on_Stained_Glass_by_R_Anning_Bell.txt"));
//		biblioteca.add(new Livro("src/livros/AlicesAdventuresinWonderland_by_LewisCarrol.txt"));
//        biblioteca.add(new Livro("src/livros/Captain_Bill_McDonald_Texas_Ranger_by_Albert_Bigelow_Paine.txt"));
//        biblioteca.add(new Livro("src/livros/Engravers_and_Etchers_by_Fitzroy_Carrington.txt"));
//        biblioteca.add(new Livro("src/livros/Heiraten_by_August_Strindberg.txt"));
//        biblioteca.add(new Livro("src/livros/La_Guerre_est_morte_by_Louis_Delluc.txt"));
//        biblioteca.add(new Livro("src/livros/The_Prize_by_Sydney_C_Grier.txt"));
//        biblioteca.add(new Livro("src/livros/theGreatGatsby_by_FScootFitzgerald.txt"));

		TreeMap<String, String> palavrasDistintasBiblioteca = new TreeMap<>();
		Integer palavraIgualBiblioteca = 0;
		String busca = "of";// Palavra ser buscada nos livros e biblioteca
		TreeMap<Integer, ArrayList<String>> cont1000 = new TreeMap<>();
		
		for (Livro l : biblioteca) {// Percorre todos os Objetos Livro

			Map<String, String> palavrasDistintasLivro = new HashMap<>();
			Map<String, Integer> palavrasIguais = new TreeMap<>();

			for (String c : l.getConteudoDoLivro()) {// Percorre Cada palavra do livro dentro do ArrayList

				// Coloca as palavras distintas de cala livro em um HashMap
				palavrasDistintasLivro.put(c, "");
				

				// conta frequencia de palavras
				if (palavrasIguais.containsKey(c)) {
					Integer contadorAntigo = palavrasIguais.get(c);
					contadorAntigo++;
					palavrasIguais.put(c, contadorAntigo);
				} else {
					Integer contador = 1;
					palavrasIguais.put(c, contador);
				}
			} // fim do for que percorre o ArrayList
			
			palavrasIguais.remove("");
			palavrasDistintasLivro.remove("");
			
			// Percorre Cada palavra do livro dentro do TreeMap
			for (String palavra : palavrasIguais.keySet()) {

			if (cont1000.containsKey(palavrasIguais.get(palavra))) {
				ArrayList<String> palavras = cont1000.get(palavrasIguais.get(palavra));
				palavras.add(palavra);

				} else {
					ArrayList<String> palavras2 = new ArrayList<>();
					palavras2.add(palavra);
					cont1000.put(palavrasIguais.get(palavra), palavras2);
				}
			} // fim do for que percorre o TreeMap

			// Adiciona as palavras distintas de cada livro em uma TreeMap biblioteca
			palavrasDistintasBiblioteca.putAll(palavrasDistintasLivro);

			// busca e armazena e intera a quantidade que a palavra aparece
			palavraIgualBiblioteca += palavrasIguais.get(busca);

			List<Map.Entry<String, Integer>> statistics = new ArrayList<>(palavrasIguais.entrySet());
			Collections.sort(statistics, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return -o1.getValue().compareTo(o2.getValue());
				}
			});

			System.out.println("\n" + l.toString());
			
//----------------------------------------------------------------------------------------------------------------
			
			// (b) Quantas palavras distintas existem em cada livro?
			System.out.println("> Quantidade de palavras distintas no livro: " + l.getNome_livro() + " = "
					+ palavrasDistintasLivro.size());
			
//---------------------------------------------------------------------------------------------------------------- 
			
			// (d) Quantas vezes a palavra "anyone" (ou qualquer outra) aparece em cada
			// livro?
			System.out.println("> A Palavra '" + busca + "' aparece " + palavrasIguais.get(busca) + " vezes no livro: "
					+ l.getNome_livro());
			
//---------------------------------------------------------------------------------------------------------------- 
			
			// (f) Qual a palavra mais frequente em cada livro?
			// Mesma questao da H)
			
//----------------------------------------------------------------------------------------------------------------
			
			// (g) Qual a palavra menos frequente em cada livro?
			// Mesma questao da L)
			
//----------------------------------------------------------------------------------------------------------------
			
			// (h) Qual as cinco (ou qualquer outro numero) palavras mais frequentes em cada
			// livro?
			System.out.println();
			List<Map.Entry<String, Integer>> one = statistics.subList(0, 5);
			int cont = 1;
			for (Map.Entry<String, Integer> word : one) {
				System.out.println(
						cont + "° Palavra mais frequente = " + word.getKey() + ": " + word.getValue() + " vezes");
				cont++;
			}
			cont = 1;
			
//---------------------------------------------------------------------------------------------------------------- 
			
			// (i) Qual as cinco (ou qualquer outro numero) palavras menos frequente em cada
			// livro?
			System.out.println();
			List<Map.Entry<String, Integer>> two = statistics.subList(statistics.size() - 5, statistics.size());
			for (Map.Entry<String, Integer> word : two) {
				System.out.println(
						cont + "° Palavra menos frequente = " + word.getKey() + ": " + word.getValue() + " vezes");
				cont++;			
			}
//----------------------------------------------------------------------------------------------------------------
			
			// (k) Retorne a lista de palavras que tenham ordem lexicografica acima de
			// "warm" (ou qualquer outra).
			String lexicograficaAcima = "warm";
			System.out.println("\n> Palavras que tenham ordem lexicografica acima de: " + lexicograficaAcima + " \n"
					+ palavrasDistintasBiblioteca.tailMap(lexicograficaAcima).keySet());
			
//---------------------------------------------------------------------------------------------------------------- 
			
			// (l) Retorne a lista de palavras que tenham ordem lexicografica abaixo de
			// "asked" (ou qualquer outra).
			String lexicograficaAbaixo = "asked";
			System.out.println("\n> Palavras que tenham ordem lexicografica abaixo de: " + lexicograficaAbaixo + " \n"
					+ palavrasDistintasBiblioteca.headMap(lexicograficaAbaixo).keySet());
		
		} // Fim do for que percorre todos os Objetos Livro

//----------------------------------------------------------------------------------------------------------------
		
		// (c) Quantas palavras distintas existem em toda biblioteca?
		System.out.println("\n> Palavras distintas Biblioteca: " + palavrasDistintasBiblioteca.size());
		
//----------------------------------------------------------------------------------------------------------------
		
		// (e) Quantas vezes a palavra "anyone" (ou qualquer outra) aparece em toda a
		// biblioteca?
		System.out.println("> A Palavra " + busca + " aparece " + palavraIgualBiblioteca + " vezes na Biblioteca");
		
//----------------------------------------------------------------------------------------------------------------   
		
		// (j) Quais as palavras com frequencia acima de 1000 (ou qualquer outro numero)
		// na biblioteca?	
		System.out.println("\nPalavras com frequencia acima de 1000 na biblioteca= \n" + cont1000.tailMap(1000,true));
	}
}

