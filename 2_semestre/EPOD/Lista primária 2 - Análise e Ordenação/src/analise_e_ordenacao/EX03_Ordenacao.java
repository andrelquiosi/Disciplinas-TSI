package analise_e_ordenacao;

import java.util.Arrays;

public class EX03_Ordenacao {

	public static void main(String[] args) {
////////QUESTÃO 1-
		int[] lista = new int[] { 54, 26, 93, 17, 77, 31, 44, 55, 20 };

		bubbleSort(lista);

////////////////////////////////////////////////////////////////////////

	}

	public static void bubbleSort(int[] lista) {

		System.out.println(Arrays.toString(lista) + "<-- lista sem Ordenar");

		int temp = 0;

		for (int i = 0; i < lista.length; i++) {

			for (int j = i + 1; j < lista.length; j++) {

				if (lista[i] > lista[j]) {

					temp = lista[i];
					lista[i] = lista[j];
					lista[j] = temp;

					System.out.println(Arrays.toString(lista));
				}
			}
		}

		System.out.println(Arrays.toString(lista) + "<-- lista Ordenada");
	}

}
