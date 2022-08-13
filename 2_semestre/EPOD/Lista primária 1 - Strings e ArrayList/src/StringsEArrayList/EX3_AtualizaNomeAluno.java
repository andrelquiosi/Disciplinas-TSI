package StringsEArrayList;

import java.util.ArrayList;

public class EX3_AtualizaNomeAluno {

	public static void main(String[] args) {
		/*
		 * 3. Dado um ArrayList de Objetos Aluno(ra,nome,nascimento,coeficiente),
		 * escreva um programa Java para atualizar o nome do aluno(a) em uma posi��o
		 * espec�fica do Arraylist (dado por um �ndice).
		 */

		ArrayList<Aluno> alunos = new ArrayList<>();// cria uma ArrayList com a classe Aluno

		alunos.add(new Aluno("123654", "Andre", "05/03/1996", 7.200));// adiciona um Aluno na possi��o 0 da ArrayList
		alunos.add(new Aluno("456321", "Lucas", "25/04/1999", 9.250));// adiciona um Aluno na possi��o 1 da ArrayList
		alunos.add(new Aluno("741852", "Marcos", "01/10/2003", 8.500));// adiciona um Aluno na possi��o 2 da ArrayList

		int indice = 2;// numero para escolher qual aluno vai ter o nome alterado

		for (Aluno s : alunos) {// imprime o ArrayList
			System.out.println(s.toString());

		}

		Aluno a = alunos.get(indice);// encontra o aluno pelo indice e o coloca na refer�ncia (a)
		a.setNome("Fred");// troca o nome do aluno

		for (Aluno s : alunos) {// imprime o ArrayList com o nome trocado
			System.out.println(s.toString());
		}

	}

}
