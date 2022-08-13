package programas;

import heranca01.*;

public class CadastroCaminhao {

	public static void main(String[] args) {

		Caminhao c1 = new Caminhao("APS2C43", 2014, 4);
		Caminhao c2 = new Caminhao("BBS5K75", 2015, 6);
		Caminhao c3 = new Caminhao("THI7J89", 2016, 7);

		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());

		c1.setEixos(5);
		System.out.println("\nc1 alterado\n");
		System.out.println(c1.toString());
	}

}
