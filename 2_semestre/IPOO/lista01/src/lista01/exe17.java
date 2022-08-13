/*7) ** Escreva um programa que leia um vetor A, com 15 elementos. Crie um vetor B, do
mesmo tamanho, que contenha primeiro todos os valores PARES de A, seguidos dos
valores ÍMPARES de A. Mostrar o vetor B resultante. */

package lista01;

import java.util.Arrays;
import java.util.Scanner;

public class exe17 {
	public static void main(String[] args) {

		int[] vet1 = { 10, 15, 31, 2, 57, 5, 6, 4, 25, 7, 45, 62, 1, 9, 85 };
		int[] vet2 = new int[vet1.length];

		int i = 0;
		int cont = 0;
		for (i = 0; i < vet1.length; i++) {
			if (vet1[i] % 2 == 0) {
				vet2[cont] = vet1[i];
				cont++;
			}
		}
		
		for (i = 0; i < vet1.length; i++) {
			if (vet1[i] % 2 != 0) {
				vet2[cont] = vet1[i];
				cont++;
			}
		}
		System.out.print(Arrays.toString(vet2));

	}

}
