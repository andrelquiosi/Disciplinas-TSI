/**/

package questoes;

import objetos.Funcionario;

public class EX05 {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario(123, "ANDRE", "A", 1000.00);
		Funcionario f2 = new Funcionario(124, "MARCOS", "B", 4000.00);
		Funcionario f3 = new Funcionario(125, "FELIPE", "C", 6000.00);
		Funcionario f4 = new Funcionario(126, "JOAO", "D", 3000.00);
		
		System.out.println(f3.toString());
		
		f3.reajuste(f3);
		
		System.out.println(f3.toString());
		
		
	}

}
