package questoes;

import java.util.Scanner;

public class Questao2 {

	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);

		int totalPessoas = 0;
		int totalF = 0;
		int totalM = 0;
		int totalB = 0;
		int totalC = 0;
		

		for (int i = 0; i != 1; i = 0) {

			System.out.print("Informe o sexo (‘M’ - Masculino, ‘F’ – Feminino): ");
			String aux = src.next();
			char sexo = aux.charAt(0);
			
			if (sexo == 'X') {
				break;
			}

			System.out.print("Informe o peso (Kg): ");
			double peso = src.nextDouble();

			System.out.print("Informe a idade: ");
			int idade = src.nextInt();

			if (sexo == 'F') {
				totalF++;
			}
			if (sexo == 'M') {
				totalM++;
			}
			if (idade >= 60 && peso > 95 && sexo == 'M') {
				totalB++;
			}
			
			if (idade >= 20 && idade <= 30 && peso < 45 && sexo == 'F') {
				totalC++;
			}

		}
		
		totalPessoas = totalF + totalM;
		double percM = (totalM * 100) / totalPessoas;
		double percF = (totalF * 100) / totalPessoas;
		double percB = (totalB * 100) / totalM;
		double percC = (totalC * 100) / totalF;
		
		System.out.printf("Total de pessoas atendidas: %d",totalPessoas);		
		System.out.printf("\nNumero e Percentual Homens:%d -  %.2f",totalM,percM);
		System.out.printf("\nNumero e Percentual Mulheres:%d -  %.2f",totalF,percF);
		System.out.printf("\nO número e o percentual de homens com 60 anos ou mais, que pesam mais de 95kg: %d - %.2f %%",totalB,percB);
		System.out.printf("\nO número e o percentual de mulheres com idade entre 20 e 30 anos, que pesam menos de 45kg: %d - %.2f %%",totalC, percC);


	}

}
