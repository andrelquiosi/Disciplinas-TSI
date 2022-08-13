/*
3. Crie uma classe Ponto , que representa um ponto no sistema cartesiano (x, y). 
Defina um construtor que receba as coordenadas do ponto.
Escreva um método que permita calcular a distância do ponto a um outro ponto,
passado por parâmetro: distancia(Ponto p)
*/

package questoes;

import objetos.Ponto;

public class EX03 {

	public static void main(String[] args) {
		
		Ponto pontoA = new Ponto(2.54,5.74);
		Ponto pontoB = new Ponto(7.66, -8.6);
		
		System.out.println(Ponto.distancia(pontoA,pontoB));
		
		

	}

}
