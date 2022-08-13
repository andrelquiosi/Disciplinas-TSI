package lista01;
import java.util.*;

public class exe13 {

	public static void main(String[] args) {
		Scanner src = new Scanner (System.in);
		double economia = 0;
		double remuneracao = 0;
		
		
		System.out.print("Informe o valor que será depositado mensalmente: ");
		double valorMensal = src.nextDouble();
		
		System.out.print("Informe a taxa de remuneração: ");
		double taxa = src.nextDouble();
		
		System.out.print("Informe o valor total a se economizar: ");
		double valorTotal = src.nextDouble();

		while (economia < valorTotal) {
			System.out.printf("\nForam depositados R$ %.2f \n",valorMensal);
			
			remuneracao = economia * (taxa/100);
			System.out.printf("Valor da remuneração: %.2f \n",remuneracao);
			
			economia = economia + (valorMensal + remuneracao);
			System.out.printf("Valor da economia atual: %.2f \n",economia);
			
		}

	}

}
