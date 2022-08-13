/*5) ** Leia 3 valores de ponto flutuante (a, b, c) e efetue o cálculo das raízes da equação de
Bhaskara (ax2 + bx + c). Se não for possível calcular as raízes, mostre a mensagem
correspondente: “Impossivel calcular”, caso haja uma divisão por 0 ou raiz de numero
negativo. Lembre-se que podem existir 1 ou duas raízes.*/

package lista01;

import java.util.*;

public class exe05 {

	public static void main(String[] args) {
		deltaCalculo();

	}
	
    static void deltaCalculo() {
    	
    	 
		Scanner src = new Scanner(System.in);
		
		System.out.println("Informe 3 valores de ponto flutuante (a, b, c)");
		
		System.out.print("a:");
		double a = src.nextFloat();
		
		System.out.print("b:");
		double b = src.nextFloat();
		
		System.out.print("c:");
		double c = src.nextFloat();
 
        double delta = (b * b) + (-4 * (a * c));
 
        if (delta >= 0) {
            calculaX(delta,b,a);
        } else {
            System.out.println("Impossivel calcular");
            System.exit(0);
        }
 
    }
 
    static void calculaX(double delta,double b,double a) {
 
        double x1 = (double) ((-(b) + Math.sqrt(delta)) / 2 * a);
        double x2 = (double) ((-(b) - Math.sqrt(delta)) / 2 * a);
 
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
 
    }

}





