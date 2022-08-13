package questoes;

import java.util.*;

public class Questao4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] vet1 = new int[10];
		int[] vet2 = new int[vet1.length];

		System.out.println("Informe 20 numeros inteiros:");
		for (int j = 0; j < vet1.length; j++) {
			System.out.print("Numero " + (j + 1) + " = ");
			vet1[j] = scan.nextInt();
		}
		System.out.println(Arrays.toString(vet1));

		int i = 0;
		int cont = 0;//cont para achar os pares e impares e ordenar os pares

		for (i = 0; i < vet1.length; i++) {
			if (vet1[i] % 2 == 0) {
				vet2[cont] = vet1[i];
				cont++;
			}
		}

		for (int k = cont; k >= 0; k--) {
			for (int j = cont; j >= 0; j--) {
				if (vet2[k] < vet2[j]) {
					int temp = vet2[k];
					vet2[k] = vet2[j];
					vet2[j] = temp;
				}
			}
		}
		int cont2 = cont;//cont2 para usar na ordenação dos impares

		for (i = 0; i < vet1.length; i++) {
			if (vet1[i] % 2 != 0) {
				vet2[cont] = vet1[i];
				cont++;
			}
		}
		for (int k = cont2; k < vet2.length; k++) {
			for (int j = cont2; j < vet2.length; j++) {
				if (vet2[k] < vet2[j]) {
					int temp = vet2[k];
					vet2[k] = vet2[j];
					vet2[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(vet2));
	}

}
