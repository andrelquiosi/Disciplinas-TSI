/*3) ** Uma revendedora de carros usados paga a seus vendedores um sal�rio fixo por m�s,
mais um valor fixo por cada carro vendido e mais 5% do valor das vendas por ele
efetuadas. Escreva um programa que leia o valor do sal�rio fixo, a quantidade de carros
vendidos, o valor total de suas vendas no m�s, e ent�o calcule e informe o sal�rio do
vendedor, discriminando tamb�m quanto ele ir� ganhar por cada tipo de remunera��o. */

package lista01;

import java.util.Scanner;

public class exe03 {

	public static void main(String[] args) {
		
		Scanner src = new Scanner(System.in);
		
		
		System.out.print("Informe o valor do salário fixo: ");
		double salario = src.nextDouble();
		
		System.out.print("Informe a quantidade carros vendidos: ");
		int quantidadeCarrosVendidos = src.nextInt();
		
		System.out.print("Informe o valor total das vendas: ");
		double totalVendasMes = src.nextDouble();
		
		System.out.print("Informe o valor fixo pago por cada carro vendido: ");
		double valorFixoPorCarro = src.nextDouble();
		
		
		double mediaCarros = (totalVendasMes / quantidadeCarrosVendidos)*0.5;
		
		double salarioTotal = valorFixoPorCarro + salario + mediaCarros;
	
		System.out.printf("Salário fixo: R$%.2f\nValor fixo pago por carro: R$%.2f\nBonus de 5%% sobre vendas: R$%.2f\nSalário total: RS%.2f",salario,valorFixoPorCarro,mediaCarros,salarioTotal);
	}

}
