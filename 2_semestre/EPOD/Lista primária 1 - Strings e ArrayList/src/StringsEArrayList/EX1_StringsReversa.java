package StringsEArrayList;

import java.util.Scanner;

public class EX1_StringsReversa {

	public static void main(String[] args) {

		/*
		 * 1. Escreva um programa chamado StringReversa, que solicita ao usu�rio uma
		 * String e imprime o reverso da String. O programa deve extrair e processar
		 * cada caractere da String. A sa�da deve ser semelhante a: Insira uma string:
		 * abacaxi O reverso da string "abacaxi" � "ixacaba".
		 */

		Scanner entrada = new Scanner(System.in);

		String string;// cria variavel String
		System.out.println("Insira uma string: ");
		string = entrada.next();// armazena o que foi digitado
		char[] ch = string.toCharArray();//converte a String para Array tipo char

		String gnirts = "";//cria variavel para armazenar o inverso

		for (int i = ch.length; i > 0; i--) {//percorre a Array (char[] ch) de tr�s para frente
			gnirts += ch[i - 1];// armazena de tr�s para frente a Array(char[] ch) dentro da (String gnirts)
		}

		System.out.printf("O reverso da string '%s' é '%s'.", string, gnirts);

		entrada.close();
	}

}
