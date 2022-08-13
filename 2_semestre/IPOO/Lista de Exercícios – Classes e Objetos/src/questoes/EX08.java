package questoes;

import objetos.Produto;

public class EX08 {

	public static void main(String[] args) {

		Produto p1 = new Produto("fita");
		Produto p2 = new Produto("caneta");
		Produto p3 = new Produto("tesoura");

		Produto[] estoqueLoja = new Produto[] { p1, p2, p3 };

		p1.setEntradas(50, 2.50);		
		p2.setEntradas(100, 1.25);		
		p3.setEntradas(20, 14.75);
		
		for(Produto p : estoqueLoja) {
			System.out.println(p.toString());
		}
		
		p1.setSaidas(2);
		p2.setSaidas(25);
		p3.setSaidas(4);

		
		for(Produto p : estoqueLoja) {
			System.out.println(p.toString());
		}

	}

}
