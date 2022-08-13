/*1) ** Faça um programa que leia as coordenadas de dois pontos, calcule e informa a distância
entre estes pontos no plano cartesiano. Use Math.sqrt() para calcular a raiz quadrada.*/

package lista01;

import java.util.Scanner;

public class exe01 {

	public static void main(String[] args) {
		

		Scanner scr = new Scanner(System.in);

		System.out.println("Informe as coordenadas do ponto 1:");
		System.out.print("x1: ");
		double x1 = scr.nextDouble();
		System.out.print("y1: ");
		double y1 = scr.nextDouble();
		
		
		System.out.println("Informe as coordenadas do ponto 2:");
		System.out.print("x2: ");
		double x2 = scr.nextDouble();
		System.out.print("y2: ");
		double y2 = scr.nextDouble();
		
		double distanciaCartesiano = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		System.out.printf("Resultado %.3f", distanciaCartesiano);
		
		scr.close();
	}


}

