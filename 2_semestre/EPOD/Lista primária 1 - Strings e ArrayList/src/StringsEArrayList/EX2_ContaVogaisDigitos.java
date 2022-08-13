package StringsEArrayList;

import java.util.Scanner;

public class EX2_ContaVogaisDigitos {

	public static void main(String[] args) {
		/*
		 * 2. Escreva um programa chamado ContaVogaisDigitos, que solicita ao usu�rio
		 * uma String, e depois conta o n�mero de vogais (a, e, i, o, u, A, E, I, O, U)
		 * e d�gitos (0-9) contidos no String. O programa deve imprimir as contagens e
		 * as porcentagens (arredondadas para 2 casas decimais) das vogais, bem como de
		 * d�gitos. 
		 * Por exemplo: 
		 * Entre com uma String: abcde12345 
		 * N�mero de vogais: 2 (20.0%) 
		 * N�mero de d�gitos: 5 (50.0%)
		 */
		
		Scanner entrada = new Scanner(System.in);

		String string;// cria variavel String
		System.out.println("Entre com uma String: ");
		string = entrada.next();// armazena o que foi digitado

		char[] ch = string.toCharArray();//converte a String para Array tipo char
		
		char[] vogais = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		char[] digitos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int totalVogais = 0;
		int totalDigitos = 0;

		for ( int i = 0; i < ch.length; i++ ) {//percorre a Array (char[] ch)
			
			
			for ( int j = 0; j < vogais.length; j++ ) {// verifica vogais
				
				if ( ch[i] == vogais[j] ) {//se tiver vogal adiciona +1 em totalVogais
					totalVogais++;
				}
			}
			
			for ( int k = 0; k < digitos.length; k++ ) {// verifica numeros
				
				if ( ch[i] == digitos[k] ) {//se tiver digito adiciona +1 em totalDigitos
					totalDigitos++;
				}
			}
		}
		double porcentV = (totalVogais * 100) / ch.length;//calcula a porcentagem de Vogais
		double porcentD = (totalDigitos * 100) / ch.length;//Calcula a pordentagem de Digitos

		System.out.printf("Numero de vogais: %d (%.2f %%)\nNumero de digitos: %d (%.2f %%)"
				, totalVogais, porcentV, totalDigitos, porcentD);

		entrada.close();
	}

}
