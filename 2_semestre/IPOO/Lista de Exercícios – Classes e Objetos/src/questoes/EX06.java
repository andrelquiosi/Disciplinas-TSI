package questoes;

import objetos.Ficha;

public class EX06 {

	public static void main(String[] args) {

	Ficha f1 = new Ficha("André", "123.456.789-10", "45 999887766", 1000, 100);
		
	System.out.println(f1.toString());
	
	f1.setValorCompra(500);
	
	System.out.println(f1.toString());
	
	f1.setPagamento(2000);
	
	System.out.println(f1.toString());
	
	f1.setValorCompra(500);
	
	System.out.println(f1.toString());
	}

}
