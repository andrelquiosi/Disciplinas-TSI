package questoes;

import java.util.*;

public class Questao3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int RA[] = new int[2];

		double P1[] = new double[RA.length];
		double P2[] = new double[RA.length];
		double media[] = new double[RA.length];
		double exame;

		for (int i = 0; i < RA.length; i++) {
			int aluno = i + 1;

			System.out.format("RA do %d° aluno: ", aluno);
			RA[i] = scan.nextInt();

			System.out.format("Nota da prova 1 : ");
			P1[i] = scan.nextDouble();

			System.out.format("Nota da prova 2: ");
			P2[i] = scan.nextDouble();

			media[i] = (P1[i] * 2 + P2[i] * 3) / 5.0;

			if (media[i] < 7.0) {
				System.out.format("Informe a nota do exame do %d° aluno: ", i + 1);
				exame = scan.nextDouble();

				media[i] = (P1[i] * 2 + P2[i] * 3 + exame * 4) / 9.0;
			}

		}

		System.out.format("\n\nReprovados: \n");
		for (int i = 0; i < RA.length; i++) {

			if (media[i] < 7.0) {
				System.out.format("%d - %.1f \n", RA[i], media[i]);

			}
		}

		System.out.format("\nAprovados: \n");
		for (int i = 0; i < RA.length; i++) {

			if (media[i] >= 7.0) {
				System.out.format("%d - %.1f \n", RA[i], media[i]);
			}
		}

	}

}
