/**
10) ** O Índice de Massa Corpórea (IMC) de uma pessoa é dado pela fórmula:
IMC = peso / (altura * altura)
onde o peso é dado em kg e a altura em metros. Escreva um programa que leia o peso e a
altura de uma pessoa, e informe sua condição, de acordo com a tabela abaixo:

IMC Condição

Até 18,5 Abaixo do peso ideal 
Acima de 18,5 até 25 Peso ideal
Acima de 25 até 30 Sobrepeso
Acima de 30 até 35 Obesidade Grau I
Acima de 35 até 40 Obesidade Grau II (severa)
Acima de 40 Obesidade Grau III (mórbida)

O programa deverá ainda indicar qual a faixa de peso ideal para a altura da pessoa.
 */
package lista01;

import java.util.*;

/**
 * @author André Quiosi
 *
 */
public class exe10 {

	public static void main(String[] args) {

		Scanner src = new Scanner(System.in);
		double peso = 0;
		double altura = 0;
		double pesoIdeal = 0;

		System.out.println("Calculo de IMC");

		System.out.print("Informe sua Altura em metros (Ex:1,74) : ");
		altura = src.nextDouble();

		System.out.print("Informe o seu peso em quilos (Ex: 75,7) : ");
		peso = src.nextDouble();

		double IMC = peso / (altura * altura);

		System.out.printf("IMC = %.2f\n", IMC);

		if (IMC <= 18.5) {
			System.out.println("Abaixo do peso ideal");
		}
		if (18.5 < IMC && IMC <= 25) {
			System.out.println("Peso ideal");
		}
		if (25 < IMC && IMC <= 30) {
			System.out.println("Sobrepeso");
		}
		if (IMC > 30 && IMC <= 35) {
			System.out.println("Obesidade Grau I");
		}
		if (IMC > 35 && IMC <= 40) {
			System.out.println("Obesidade Grau II");
		}
		if (IMC > 40) {
			System.out.println("Obesidade Grau III");
		}
		if (IMC < 18.5 || IMC > 25) {
			pesoIdeal = 21.75 * (altura * altura);
			System.out.printf("O peso ideal é %.2f", pesoIdeal);
		}

	}

}
