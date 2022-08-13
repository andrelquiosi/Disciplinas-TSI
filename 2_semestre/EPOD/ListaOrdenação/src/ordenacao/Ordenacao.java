package ordenacao;

import java.util.Arrays;

public class Ordenacao {

	public static void main(String[] args) {

////////QUESTÃO 1-
		int[] lista = new int[] { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
		// System.out.println(Arrays.toString(lista));

		// bubbleSort(lista);

		// System.out.println(Arrays.toString(lista));
////////////////////////////////////////////////////////////////////////

////////QUESTAO 2-
		int v1[] = { 2, 4, 6, 8, 10, 12 };
		int v2[] = { 11, 9, 7, 5, 3, 1 };
		int v3[] = { 5, 7, 2, 8, 1, 6 };
		int v4[] = { 2, 4, 6, 8, 10, 12, 11, 9, 7, 5, 3, 1 };
		int v5[] = { 2, 4, 6, 8, 10, 12, 1, 3, 5, 7, 9, 11 };
		int v6[] = { 8, 9, 7, 9, 3, 2, 3, 8, 4, 6 };
		int v7[] = { 89, 79, 32, 38, 46, 26, 43, 38, 32, 79 };

//		bubbleSort(v1);
//		insertionSort(v1);
//		selectionSort(v1);
//		
//		bubbleSort(v2);
//		insertionSort(v2);
//		selectionSort(v2);
//		
//		bubbleSort(v3);
//		insertionSort(v3);
//		selectionSort(v3);
//		
//		bubbleSort(v4);
//		insertionSort(v4);
//		selectionSort(v4);
//		
//		bubbleSort(v5);
//		insertionSort(v5);
//		selectionSort(v5);
//		
//		bubbleSort(v6);
//		insertionSort(v6);
//		selectionSort(v6);
//		
//		bubbleSort(v7);
//		insertionSort(v7);
//		selectionSort(v7);

	}

	public static void bubbleSort(int[] lista) {

		System.out.println(Arrays.toString(lista) + "<-- lista sem alterar");

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

		System.out.println(Arrays.toString(lista) + "<-- lista alterada");
	}

	public static void insertionSort(int[] lista) {

		System.out.println(Arrays.toString(lista) + "<-- lista sem alterar");

		for (int i = 0; i < lista.length; i++) {

			int temp = lista[i];
			int j = 0;

			for (j = i - 1; j >= 0 && temp < lista[j]; j--) {

				lista[j + 1] = lista[j];
				System.out.println(Arrays.toString(lista));

			}

			lista[j + 1] = temp;

		}

		System.out.println(Arrays.toString(lista) + "<-- lista alterada");
	}

	public static void selectionSort(int[] lista) {

		System.out.println(Arrays.toString(lista) + "<-- lista sem alterar");

		for (int i = 0; i < lista.length - 1; i++) {

			int aux = i;

			for (int j = i + 1; j < lista.length; j++) {

				if (lista[j] < lista[i])
					aux = j;

				int temp = lista[aux];
				lista[aux] = lista[i];
				lista[i] = temp;

				System.out.println(Arrays.toString(lista));
			}
		}
		System.out.println(Arrays.toString(lista) + "<-- lista alterada");
	}

}
