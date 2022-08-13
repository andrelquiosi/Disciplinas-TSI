package arrayList;

import java.util.ArrayList;

import objetos.Aluno;

public class EX01 {

	public static void main(String[] args) {
		/*
		 * 1. Escreva um programa Java para criar um ArrayList de Strings, adicione
		 * algumas strings, percorra e imprima o ArrayList sequencialmente. (a) Refa�a o
		 * exerc�cio acima para um ArrayList de Objetos
		 * Aluno(ra,nome,nascimento,coeficiente).
		 */

		//arrayList();
		arrayListObjetos();

	}

	public static void arrayList() {
		ArrayList<String> strings = new ArrayList<>();
		

		strings.add( "André" );
		strings.add( "Luis" );
		strings.add( "Quiosi" );
		strings.add( "25 anos" );

		for ( String s : strings ) {
			System.out.print( s + " " );

		}

	}
 public static void arrayListObjetos() {
	 
	 ArrayList<Aluno> alunos = new ArrayList<>();
	 
	 alunos.add( new Aluno( "123654", "Andr�", "05/03/1996", 7.200 ) );
	 alunos.add( new Aluno( "456321", "Lucas", "25/04/1999", 9.250 ) );
	 alunos.add( new Aluno( "741852", "Marcos", "01/10/2003", 8.500 ) );
	 
		for ( Aluno s : alunos ) {
			System.out.println( s.toString() );

		}
	 
 }


}
