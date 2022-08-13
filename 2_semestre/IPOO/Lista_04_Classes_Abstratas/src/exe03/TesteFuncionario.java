package exe03;

import exe03.*;

public class TesteFuncionario {

	public static void main(String[] args) {
		
		Vendedor V1 = new Vendedor("Ricardo",2550.50,"FrontEnd");
		System.out.println(V1.toString());
		
		Comissionado C1 = new Comissionado("João",3575.00,"Vendas",13,50);
		System.out.println(C1.toString());
		
		Estoquista E1 = new Estoquista("André",1759.00,01);
		System.out.println(E1.toString());
		
		GerenteVendas GV1 = new GerenteVendas("Roberto",50,13);
		System.out.println(GV1.toString());
		
		GerenteSetor GS1 = new GerenteSetor("Marcos",7150.00,150);
		System.out.println(GS1.toString());
	}

}
