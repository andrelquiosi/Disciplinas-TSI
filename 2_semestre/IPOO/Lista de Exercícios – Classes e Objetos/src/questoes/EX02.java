/*
2. Crie uma classe Data capaz de representar uma data com dia, mês e ano.
Esta classe deve possuir um método que retorne a data em um String
formatada (dd/mm/aaaa) . Crie outra classe com o método main() para testar.
Classe: Data
Atributos: dia, mês, ano
Métodos:
String formatarData()
*/

package questoes;

import objetos.Data;

public class EX02 {

	public static void main(String[] args) {
		
		Data data1 = new Data(05,03,1996);
		
		System.out.println(data1.formatarData());

	}

}
