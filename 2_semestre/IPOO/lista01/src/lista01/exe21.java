package lista01;

import java.util.*;

public class exe21 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String aux;
		String[] nome = new String[50];
		String[] gab = new String[10];
		double[] media = new double[50];
		

		System.out.println("Preencha o gabarito de 'A' a 'E'");
		for (int i = 0; i < 10; i++) {
			System.out.print("Questão " + (i + 1) + ": ");
			gab[i] = scan.next();
			

		}

		//Le os nomes dos alunos
		int cont = 0;
		for (int i = 0; i < 3; i++) {
			System.out.print("Nome do aluno: ");
			nome[i] = scan.next();

			if (nome[i].intern() == "FIM") {
				break;
			}
			
			//Le as notas do aluno e soma as corretas
			double nota = 0;
			for (int j = 0; j < 10; j++) {
				String questao = new String();
				System.out.printf("Gabarito questão %d: ",(j+1));
				questao = scan.next();
				
				
				if (gab[i].equals(questao)) {
					nota++;
				}
			}
			
			media[i] = nota;	
			cont++;			
		}
		
		for (int i = 0; i < cont; i++) {
			System.out.printf("Nome: %s Nota: %.1f\n",nome[i],media[i]);

		}

	}

}
