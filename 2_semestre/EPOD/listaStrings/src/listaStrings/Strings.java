package listaStrings;

import java.util.*;

public class Strings {

	public static void main(String[] args) {
//		questao1();
//      questao2();
//		questao3();
//		questao4();
//		questao5();
//		questao6();
//		questao7();
//		questao8();
//		questao9();
//		questao10();
//		questao11();
//		questao12();
//		questao13();
//		StringReversa();
//		ContaVogaisDigitos();
//		questao16();
//		ChecaStringBinaria();
//		TestaPalindromo();
//		questao19();
		questao20();

	}

	private static void questao20() {
		/*
		 * 20. Fa�a um programa que leia uma data de nascimento no formato dd/mm/aaaa e
		 * imprima a data com o m�s escrito por extenso. Entrada = 20/01/2000 Nasceu em
		 * 20 de fevereiro de 2000
		 */

		Scanner entrada = new Scanner(System.in);

		String string;

		System.out.println("Entre com pal�ndromo: ");
		string = entrada.next();

		String diaNumeral = string.substring(0, 2);
		String mesNumeral = string.substring(3, 5);
		int intMes = Integer.parseInt(mesNumeral);
		String anoNumeral = string.substring(6, 10);
		String mesEstenso = "  ";

		System.out.println(diaNumeral);
		System.out.println(mesNumeral);
		System.out.println(anoNumeral);

		switch (intMes) {
		case 1:
			mesEstenso = "Janeiro";
			break;
		case 2:
			mesEstenso = "Fevereiro";
			break;
		case 3:
			mesEstenso = "Março";
			break;
		case 4:
			mesEstenso = "Abril";
			break;
		case 5:
			mesEstenso = "Maio";
			break;
		case 6:
			mesEstenso = "Junho";
			break;
		case 7:
			mesEstenso = "Julho";
			break;
		case 8:
			mesEstenso = "Agosto";
			break;
		case 9:
			mesEstenso = "Setembro";
			break;
		case 10:
			mesEstenso = "Outubro";
			break;
		case 11:
			mesEstenso = "Novembro";
			break;
		case 12:
			mesEstenso = "Dezembro";
			break;
		}

		System.out.printf("Nasceu em %s de %s de %s", diaNumeral, mesEstenso, anoNumeral);

		entrada.close();

	}

	private static void questao19() {
		/*
		 * 19. Escreva um programa que leia o nome do usu�rio e o imprima na vertical,
		 * em forma de escada, usando apenas letras mai�sculas. Por exemplo: Nome: Pena
		 * P PE PEN PENA
		 */

		Scanner entrada = new Scanner(System.in);

		String string;

		System.out.println("Entre com pal�ndromo: ");
		string = entrada.next();

		string = string.toUpperCase();

		char[] stringToChar = string.toCharArray();

		for (int i = 0; i < stringToChar.length; i++) {

			for (int j = 0; j <= i; j++) {

				System.out.print(stringToChar[j]);
			}
			System.out.print("\n");
		}

		entrada.close();

	}

	private static void TestaPalindromo() {
		/*
		 * 18. Um pal�ndromo (palavra) pode ser lido, indiferentemente, da esquerda para
		 * a direita, conforme o sentido habitual da leitura, ou da direita para a
		 * esquerda, sem que haja mudan�a da sua significa��o, por exemplo, "ovo",
		 * "ana","osso"(ignorando case). Escreva um programa chamado TestaPalindromo,
		 * que solicita ao usu�rio uma palavra e verifica se a palavra digitada � ou n�o
		 * um pal�ndromo.
		 */

		Scanner entrada = new Scanner(System.in);

		String string;

		System.out.println(
				"Um pal�ndromo (palavra) pode ser lido, indiferentemente, da esquerda para a direita\nPor exemplo, ovo, ana, osso, ...");
		System.out.println("Entre com pal�ndromo: ");
		string = entrada.next();

		char[] stringToChar = string.toCharArray();

		String gnirts = "";

		for (int i = stringToChar.length; i > 0; i--) {
			gnirts += stringToChar[i - 1];
		}

		boolean verifica = gnirts.equals(string);

		if (verifica == true) {
			System.out.printf("'%s' � um pal�ndromo!", string);
		} else {
			System.out.printf("'%s' n�o � um pal�ndromo!", string);
		}

		entrada.close();

	}

	private static void ChecaStringBinaria() {
		/*
		 * 17. Escreva um programa chamado ChecaStringBinaria para verificar se uma
		 * String � bin�ria ou n�o. Por exemplo: Entre com a String: 10101100 "10101100"
		 * � bin�ria Entre com a String: 10120000 "10120000" n�o � bin�ria
		 */
		Scanner entrada = new Scanner(System.in);

		String string;
		System.out.println("Entre com a String: ");
		string = entrada.next();

		boolean testeBinario = string.matches("[0-1]+");// verifica se a string est� entre 0 e 1

		if (testeBinario == true) {
			System.out.printf("'%s' � bin�rio");
		} else {
			System.out.printf("'%s' n�o � bin�rio");
		}

		entrada.close();
	}

	private static void questao16() {// ---------------------------------------------
		/*
		 * 16. O C�digo de C�sar � uma t�cnica de criptografia bem simples. Cada letra
		 * do texto inicial � substitu�da por outra letra do alfabeto (dada uma
		 * dist�ncia de letras n). Em outras palavras, a substitui��o � feita com base
		 * na posi��o relativa do car�cter no alfabeto. Por exemplo, seja n = 3. Neste
		 * caso, �A� � substitu�do por �D�, �B� por �E�, �C� por �F�, ..., �X� por �A�,
		 * ..., �Z� por �C�, e assim por diante. Assumindo Strings contendo apenas
		 * letras do alfabeto, escreva um programa chamado CodigoCesar para criar o
		 * c�digo do C�sar de uma String. O programa deve solicitar ao usu�rio o valor
		 * da dist�ncia de letras n, e uma String de texto simples consistindo apenas de
		 * letras mai�sculas e min�sculas; computar o texto cifrado; e imprimir o texto
		 * cifrado em mai�sculas.
		 * 
		 * � Escreva um programa chamado DecifraCodigo para decifrar o c�digo de C�sar
		 * descrito no exerc�cio anterior. De forma similar ao item anterior, o
		 * programa deve solicitar ao usu�rio o valor da dist�ncia de letras n, e uma
		 * String de texto simples consistindo apenas de letras mai�sculas e min�sculas;
		 * computar o texto decifrado; e imprimir o texto decifrado em mai�scula
		 */

		String textoCifrado = "";

		for (int i = 0; i < textoOriginal.length(); i++) {
			textoCifrado += encriptar(textoOriginal.charAt(i), chave);
		}

		char charCifrado;

		if (charOriginal >= 97 && charOriginal <= 122) {
			charCifrado = (char) ((charOriginal - 97 + chave) % 26 + 97);
		} else if (charOriginal >= 65 && charOriginal <= 90) {
			charCifrado = (char) ((charOriginal - 65 + chave) % 26 + 65);
		} else {
			charCifrado = charOriginal;
		}
	}

	private static void ContaVogaisDigitos() {
		/*
		 * 15. Escreva um programa chamado ContaVogaisDigitos, que solicita ao usu�rio
		 * uma String, e depois conta o n�mero de vogais (a, e, i, o, u, A, E, I, O, U)
		 * e d�gitos (0-9) contidos no String. O programa deve imprimir as contagens e
		 * as porcentagens (arredondadas para 2 casas decimais) das vogais, bem como de
		 * d�gitos. Por exemplo: Entre com uma String: abcde12345 N�mero de vogais: 2
		 * (20.0%) N�mero de d�gitos: 5 (50.0%)
		 */

		Scanner entrada = new Scanner(System.in);

		String str;
		System.out.println("Entre com uma String: ");
		str = entrada.next();

		char[] ch = str.toCharArray();
		char[] vogais = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		char[] digitos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int totalVogais = 0;
		int totalDigitos = 0;

		for (int i = 0; i < ch.length; i++) {
			// verifica vogais
			for (int j = 0; j < vogais.length; j++) {
				if (ch[i] == vogais[j]) {
					totalVogais++;
				}
			}
			// verifica numeros
			for (int k = 0; k < vogais.length; k++) {
				if (ch[i] == digitos[k]) {
					totalDigitos++;
				}
			}
		}
		double porcentV = (totalVogais * 100) / ch.length;
		double porcentD = (totalDigitos * 100) / ch.length;

		System.out.printf("N�mero de vogais: %d (%.2f %%) N�mero de d�gitos: %d (%.2f %%)", totalVogais, porcentV,
				totalDigitos, porcentD);

		entrada.close();
	}

	private static void StringReversa() {
		/*
		 * 14. Escreva um programa chamado StringReversa, que solicita ao usu�rio uma
		 * String e imprime o reverso da String. O programa deve extrair e processar
		 * cada caractere da String. A sa�da deve ser semelhante a: Insira uma string:
		 * abacaxi O reverso da string "abacaxi" � "ixacaba".
		 */

		Scanner entrada = new Scanner(System.in);

		String str;
		System.out.println("Insira uma string: ");
		str = entrada.next();
		char[] ch = str.toCharArray();

		String rts = "";

		for (int i = ch.length; i > 0; i--) {
			rts += ch[i - 1];
		}

		System.out.printf("O reverso da string '%s' � '%s'.", str, rts);

		entrada.close();
	}

	private static void questao13() {
		/*
		 * 13. Escreva um programa Java para contar as ocorr�ncias de uma String s1 em
		 * outra String s2.
		 */

		String s1 = "a";
		char[] c1 = s1.toCharArray();
		String s2 = "Eu gosto de ir ao mercado comprar carne para o churrasco!";

		int cont = 0;
		for (int i = 0; i < s2.length(); i++) {

			if (s2.charAt(i) == c1[0]) {
				cont++;

			}
		}
		System.out.println(cont);

	}

	private static void questao12() {// ----------------------------------
		/*
		 * 12. Escreva um programa Java para calcular a soma dos n�meros que aparecem em
		 * uma determinada String.
		 */

		String numeros = "1 2 3 4 5 6 7 8 9 10";
		String[] converteArray = numeros.split(" ");

		for (int i = 0; i < converteArray.length; i++) {

		}

	}

	private static void questao11() {
		/*
		 * 11. Escreva um programa Java para verificar se uma determinada string come�a
		 * com o conte�do de outra string, por exemplo:
		 * "Vermelho � a minha cor favorita." Come�a com "Vermelho"? True
		 * "Laranja tamb�m � minha cor favorita." Come�a com "Vermelho"? False
		 */

		String str1 = "Vermelho � a minha cor favorita.";
		String str2 = "Laranja tamb�m � minha cor favorita.";

		String str1StripIdent = str1.stripIndent();
		String str2StripIdent = str2.stripIndent();

		String[] a = str1StripIdent.split(" ");

		boolean tf = str2StripIdent.startsWith(a[0]);

		System.out.println(tf);

	}

	private static void questao10() {// ----------------------------------
		/*
		 * 10. Escreva um programa Java que recebe uma frase e retorna o n�mero de
		 * palavras que a frase cont�m. Considere que a frase pode come�ar e/ou terminar
		 * por espa�os. A entrada e sa�da de dados deve ser feita no programa principal.
		 */

		Scanner entrada = new Scanner(System.in);

		String str = new String();
		System.out.println("Escreva uma frase: ");
		str = entrada.next();

		String str2 = str.stripIndent();

		System.out.print(str.stripIndent());

	}

	private static void questao9() {
		/*
		 * 9. Escreva um programa Java para criar um novo objeto String com o conte�do
		 * de um vetor de caracteres.
		 */

		char[] ch = { 'A', 'n', 'd', 'r', 'e', ' ', 'L', 'u', 'i', 's' };
		String str = new String();

		for (int i = 0; i < ch.length; i++) {
			str = str + ch[i];
		}

		System.out.print(str);
	}

	private static void questao8() {
		/*
		 * 8. Escreva um programa Java para remover os espa�os em branco � esquerda ou �
		 * direita de uma String.
		 */
		String str = "    Ol� Mundo Maluco   ";
		char[] ch = str.toCharArray();

		System.out.println(Arrays.toString(ch));

		/////////////// remove espa�os do come�o//////////////////////////////////////
		int i;
		for (i = 0; ch[i] == ' '; i++) {

			if (ch[i] != ' ') {
				break;
			}
		}

		char[] ch2 = new char[str.length() - i];
		for (int j = i; j < str.length(); j++) {
			ch2[j - i] = ch[j];
		}

		System.out.println(Arrays.toString(ch2));

		/////////////////////// Remove espa�os do
		/////////////////////// fim///////////////////////////////////////////
		int control = 0;
		for (int k = ch2.length - 1; ch2[k] == ' '; k--) {

			if (ch2[k] != ' ') {
				break;
			}
			control++;
		}
		char[] ch3 = new char[ch2.length - control];
		for (int l = 0; l < ch3.length; l++) {
			ch3[l] = ch2[l];
		}
		System.out.println(Arrays.toString(ch3));

		/////////////////// Converte vetor char para
		/////////////////// String///////////////////////////////////////////
		System.out.println(str.valueOf(ch3));

	}

	private static void questao7() {/** FRASE TO LOWER ************/
		/*
		 * 7. Escreva um programa Java para converter todos os caracteres em uma String
		 * em min�sculas.
		 */

		Scanner entrada = new Scanner(System.in);

		String str = new String("");
		System.out.println("Escreva uma palavra em MAIUSCULO: ");
		str = entrada.next();

		System.out.println("Voc� digitou: " + str);

		System.out.print("E ficou : " + str.toLowerCase());

		entrada.close();

	}

	private static void questao6() {
		/*
		 * 6. Escreva um programa Java para substituir o caractere em uma posi��o da
		 * String por outro caractere.
		 */

		char substituir = 'a';
		char substituto = 'o';

		String a = "Carro de boi";

		System.out.println(a);
		System.out.print(a.replace(substituir, substituto));

	}

	private static void questao5() {
		/*
		 * 5. Escreva um programa Java para concatenar uma String s1 ao final de outra
		 * String s2.
		 */

		String s1 = "Andr� ";
		String s2 = "Quiosi ";

		System.out.print(s1.concat(s2));

	}

	private static void questao4() {
		/*
		 * 4. Escreva um programa Java para comparar duas strings lexicograficamente,
		 * ignorando as diferen�as de mai�sculas e min�sculas.
		 */

		String a = "ABC";
		String b = "abc";

		int c = a.compareToIgnoreCase(b);

		if (c < 0 || c > 0) {
			System.out.print("A Strint 'a' � diferente da String 'b'");
		} else {
			System.out.print("A Strint 'a' � lexicograficamente igual da String 'b'");
		}

	}

	private static void questao3() {
		/*
		 * 3. Escreva um programa Java para contar o n�mero de caracteres �a� dentro de
		 * uma String.
		 */

		Scanner entrada = new Scanner(System.in);

		String palavra;
		System.out.println("Escreva alguma coisa: ");
		palavra = entrada.next();

		char[] chars = palavra.toCharArray();

		int cont = 0;

		for (int i = 0; i < palavra.length(); i++) {

			if (palavra.charAt(i) == 'a') {

				cont++;
			}
		}

		System.out.printf("O que voc� escreveu contem %d letras 'a'", cont);

		entrada.close();

	}

	private static void questao2() {
		/*
		 * 2. Escreva um programa Java para obter o comprimento de uma determinada
		 * String.
		 */
		Scanner entrada = new Scanner(System.in);

		String palavra;
		System.out.println("Escreva alguma coisa: ");
		palavra = entrada.next();

		System.out.println("O tamanho da String do que foi digitado �: " + palavra.length());

		entrada.close();

	}

	private static void questao1() {
		/*
		 * 1. Escreva um programa que obtenha e apresente na tela um caractere dentro de
		 * uma String. A posi��o do caractere � dada por um �ndice fornecido pelo
		 * usu�rio.
		 */
		Scanner entrada = new Scanner(System.in);

		String palavra;
		System.out.println("Escreva uma palavra sem espa�os: ");
		palavra = entrada.next();

		System.out.println("Sua palavra �: " + palavra + ".\nAgora informe um nume inteiro de 0 a "
				+ (palavra.length() - 1) + ":");
		char caractere = palavra.charAt(entrada.nextInt());

		System.out.print("O caractere selecionado �: " + caractere);

		entrada.close();

	}

}
