package analise_e_ordenacao;

import java.util.Arrays;

public class EX02_ElementosDistindos {

	public static void main(String[] args) {
		int[] elementos = new int[] { 1, 5, 3, 27, 2, 6, 7, 10, 9, 8, 51, 7, 96, 27, 48, 99, 25, 80, 60, 79 };

		System.out.println(disjuntosA(elementos));
		System.out.println(Arrays.toString(elementos));

		System.out.println(disjuntosB(elementos));
		System.out.println(Arrays.toString(elementos));

	}

	// (a) Escreva um algoritmo cujo pior caso seja O(N^2).
	public static boolean disjuntosA(int[] elemento) {
		for (int i = 0; i < elemento.length; i++) {

			for (int j = i + 1; j < elemento.length; j++) {

				if (elemento[i] == elemento[j]) {
					System.out.println(elemento[i] + ", " + elemento[j]);
					return true;
				}
			}

		}
		return false;
	}

	/*
	 * (b) O m�todo Arrays.sort(vetor) ordena um vetor em ordem ascendente. Os
	 * melhores algoritmos de ordena��o (inclu�dos em Arrays.sort(vetor)) est�o em
	 * O(N log(N))). Assuma que o m�todo Arrays.sort(vetor) possa ser utilizado e
	 * escreva um novo algoritmo/programa para o exerc�cio acima. Qual a
	 * complexidade do novo algoritmo? Explique.
	 * 
	 * R: O novo algoritmo quando usado em um pequeno conjunto de dados consome mais
	 * recursos, pois realiza primeiro a ordena��o para depois procurar se o
	 * elemento � igual ao outro. Por�m, tamb�m as chances de se encontrar elementos
	 * iguais � maior, porque no processo de ordenar, os elemntos iguais ficar�o um
	 * ao lado do outro, sendo desnecess�rio percorrer todo o array. EX: Na forma
	 * desordenada se o primeiro e o ultimo elemento forem iguais o scrypt tem que
	 * percorrer todo o array para verificar, mas, se caso o array estiver ordenado
	 * esses dois elemento ir�o estar logo nas 2 primeiras posi��es, eliminando
	 * assim a necessidade de percorrer todo o array.
	 */
	public static boolean disjuntosB(int[] elemento) {

		Arrays.sort(elemento);

		for (int i = 0; i < elemento.length; i++) {

			if (elemento[i] == elemento[i + 1]) {
				System.out.println(elemento[i] + ", " + elemento[i+1]);
				return true;
			}
		}
		return false;
	}
}
