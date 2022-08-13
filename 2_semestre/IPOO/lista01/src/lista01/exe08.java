/*8) ** Num posto de combustíveis os preços dos combustíveis são: Etanol: R$ 4,69, Gasolina:
6,01 e Diesel: R$ 5,09. Se o cliente abastecer mais de 40 litros de gasolina, ou 30 litros de
Etanol, ou mais de 80 litros de Diesel, ganha 5% de desconto. Escreva um programa que
leia o tipo de combustível (E, G ou D) e a quantidade de litros abastecidos, informe o valor
normal, o valor de desconto (se não houver, informar 0,00) e o valor final a pagar.
*/

package lista01;

import java.util.*;

public class exe08 {

	public static void main(String[] args) {

		double e = 4.69;
		double g = 6.01;
		double d = 5.09;
		int litros = 0;
		double total = 0;
		double totalFinal = 0;
		double desconto = 0.05;
		double totalDesconto = 0.00;

		Scanner src = new Scanner(System.in);

		System.out.printf("Os preços dos combustíveis são:\nEtanol: R$%.2f\nGasolina: R$%.2f\nDiesel: R$%.2f\nInforme o combustível desejado com E, G ou D: ", e,g,d);
		String combustivel = src.next();

		System.out.print("Informe quantos litros deseja: ");
		litros = src.nextInt();
			
		if("E".equals(combustivel)) {
			total = litros * e;
			
			if (litros >= 30 && "E".equals(combustivel)) {
				totalDesconto = total * desconto;
				totalFinal = total - totalDesconto;
				
			}else {
				totalFinal = total;
			}
		}
		if("G".equals(combustivel)) {
			total = litros * g;	
			
			if (litros >= 40 && "G".equals(combustivel)) {
				totalDesconto = total * desconto;
				totalFinal = total - totalDesconto;
				
			}else {
				totalFinal = total;
			}
		}
		else if("D".equals(combustivel)) {
			total = litros * d;
			
			if (litros >= 80 && "D".equals(combustivel)) {
				totalDesconto = total * desconto;
				totalFinal = total - totalDesconto;
				
			}else {
				totalFinal = total;
			}
		}
		
		System.out.printf("Valor normal R$%.2f\n",total);
		System.out.printf("Total de desconto R$%.2f\n",totalDesconto);
		System.out.printf("Total a pagar R$%.2f\n",totalFinal);
		
		

		src.close();
	}

}
