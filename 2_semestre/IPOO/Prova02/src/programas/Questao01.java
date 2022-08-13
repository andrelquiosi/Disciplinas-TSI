package programas;

import objetos.*;

public class Questao01 {

	public static void main(String[] args) {
		
		Servico prog = new Servico("Desenvolvimento App",200, 275.00, 45.50);
		
				double vlr = prog.registrar(120); // executadas 120 horas, pagar 33.000,00 
				int resta = prog.getSaldoHoras(); // retorna 80, 200 – 120 já trabalhadas.
				vlr = prog.registrar(110); // a soma passa 30 horas, estas 30 custarão 320,50
				 // vlr = 80 * 275 + 30 * 320,50 = 31615,00 
				resta = prog.getSaldoHoras(); // retorna -30, já excedidas
				prog.encerrar(); // a partir deste ponto, não registrar mais horas executadas.		
				
				

	}

}
