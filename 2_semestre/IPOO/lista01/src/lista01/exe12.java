/**
 12) ** Escreva um programa que leia um valor a pagar X (inteiro, sem centavos), calcule e
informe quantas notas de 100, 50, 20, 10, 5, 2 e moedas de 1 serão necessárias para quitar o
valor. Omitir as notas/moeda cuja quantidade for 0. Exemplo: para pagar R$ 279 são
necessárias 2 notas de 100, 1 nota de 50, 1 nota de 20, 1 nota de 5 e 2 notas de 2
 */
package lista01;

import java.util.*;

/**
 * @author André Quiosi
 *
 */

public class exe12 {

	public static void main(String[] args) {

		Scanner src = new Scanner(System.in);
		int valor;
		int nota100;
		int nota50;
		int nota10;
		int nota5;
		int nota2;
		int moeda1;

		System.out.print("Informe um valor: ");
		valor = src.nextInt();

		nota100 = valor / 100;
		valor = valor - (nota100 * 100);

		nota50 = valor / 50;
		valor = valor - (nota50 * 50);

		nota10 = valor / 10;
		valor = valor - (nota10 * 10);

		nota5 = valor / 5;
		valor = valor - (nota5 * 5);
		
		nota2 = valor / 2;
		valor = valor - (nota2 * 2);

		moeda1 = valor;

		if (nota100 > 0) {
			System.out.println("Notas de 100: " + nota100);
		}
		if (nota50 > 0) {
			System.out.println("Notas de 50: " + nota50);
		}
		if (nota10 > 0) {
			System.out.println("Notas de 10: " + nota10);
		}
		if (nota5> 0) {
			System.out.println("Notas de 5: " + nota5);
		}
		if (nota2> 0) {
			System.out.println("Notas de 2: " + nota2);
		}
		if (moeda1 > 0) {
			System.out.println("Moedas de 1: " + moeda1);
		}

	}

}
