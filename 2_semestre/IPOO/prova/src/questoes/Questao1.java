package questoes;

import java.util.*;

public class Questao1 {

	public static void main(String[] args) {

		Scanner src = new Scanner(System.in);

		System.out.print("Informe o peso total das mercadorias (kg): ");
		int peso = src.nextInt();

		System.out.print("Informe a distância a percorrer (km): ");
		int distancia = src.nextInt();

		double valFixo = 300;
		double valTonelada = 15;
		double taxaRetorno = 0;

		if (distancia > 300) {
			taxaRetorno = 80;
		}

		int quantidadeTon = peso / 1000;
		if (peso % 1000 != 0) {
			quantidadeTon ++;
		}

		int quantidadeDist = distancia / 10;
		if (distancia % 10 != 0) {
			quantidadeDist ++;
		}

		double valPeso = valTonelada * quantidadeTon * quantidadeDist;
		double totalFrete = valPeso + valFixo + taxaRetorno;

		System.out.printf(
				"Viagem (fixo): R$ %.2f \nValor pelo peso: R$ %.2f \nTaxa de retorno = R$ %.2f \nTOTAL DO FRETE: R$ %.2f",
				valFixo, valPeso, taxaRetorno, totalFrete);
	}

}
