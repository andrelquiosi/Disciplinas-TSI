package programas;

import heranca01.*;

public class CadastroOnibus {

	public static void main(String[] args) {

		Onibus o1 = new Onibus("APS2C43", 2014, 45);
		Onibus o2 = new Onibus("BBS5K75", 2015, 44);
		Onibus o3 = new Onibus("THI7J89", 2016, 38);

		System.out.println(o1.toString());
		System.out.println(o2.toString());
		System.out.println(o3.toString());
		
		o1.setAssentos(12);

		System.out.println(o1.toString());
	}

}
