package questoes;

import java.util.Arrays;
import java.util.Scanner;

public class Questao5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Informe a quantidade de linhas da Matriz: ");
		int linhas = scan.nextInt();

		System.out.print("Informe a quantidade de colunas da Matriz: ");
		int colunas = scan.nextInt();

		int[][] matriz = new int[linhas][colunas];

		System.out.println("Informe os numeros dentro da Matriz: ");

		for (int i = 0; i < linhas; i++) {
			System.out.printf("Linha %d\n", (i + 1));
			for (int j = 0; j < colunas; j++) {
				System.out.printf("%d°: ", (j + 1));
				matriz[i][j] = scan.nextInt();
			}
		}
		double[] vet1 = new double[linhas];
		int[] vet2 = new int[colunas];

		mediaEMaior(matriz, vet1, vet2);

	}

	public static void mediaEMaior(int matriz[][], double vet1[], int vet2[]) {
		
		//Print Matriz
		System.out.println("\nMatriz: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println(" ");
		}

		// acha a média
		for (int i = 0; i < matriz.length; i++) {
			int aux1 = 0;
			for (int j = 0; j < matriz.length; j++) {
				aux1 = aux1 + matriz[i][j];

			}
			vet1[i] = aux1 / vet2.length;
			aux1 = 0;
		}
		System.out.print("\nVet1: ");
		System.out.println(Arrays.toString(vet1));
		
		// acha o maior
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] > vet2[j]) {
					vet2[j] = matriz[i][j];
				}

			}
		}
		System.out.print("\nVet2: ");
		System.out.println(Arrays.toString(vet2));

	}

}
