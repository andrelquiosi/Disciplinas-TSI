package lista01;

import java.util.*;

public class exe23 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double[] pesos = new double[100];
		double soma = 0;
		double media = 0;
		double desvio = 0;
		double resultado = 0;
		double media2xDesvio = 0;

		for (int i = 0; i < pesos.length; i++) {
			System.out.printf("Informe o peso %d°: ", (i + 1));
			pesos[i] = scan.nextDouble();

			soma = soma + pesos[i];
		}

		media = soma / pesos.length;

		for (int i = 0; i < pesos.length; i++) {
			desvio = desvio + Math.pow((pesos[i] - media), 2);

		}

		media2xDesvio = media - (2 * (desvio/1000));
		int abaixo = 0;
		for (int i = 0; i < pesos.length; i++) {
			if (pesos[i] < media2xDesvio) {
				abaixo++;
			}

		}

		resultado = Math.sqrt(desvio / pesos.length);
		double porcentagem = (abaixo * 100) / pesos.length;

		System.out.printf("Media %.3f Kg\n", media);
		System.out.printf("Desvio %.3f Kg\n", desvio);
		System.out.printf("Percentual de frangos 2X abaixo do desvio padão: %.2f%%", porcentagem);

	}

}
