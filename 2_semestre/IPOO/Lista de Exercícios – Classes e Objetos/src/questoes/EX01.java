/*
1. Crie uma classe pessoa simples, com os dois atributos definidos abaixo. Crie
um objeto da classe pessoa, ajuste seu nome e idade. Simule alguns
aniversários num laço (aumentando a idade), e em seguida imprima seu
nome e sua idade. Crie outra classe com o método main() para testar.
Classe: Pessoa
Atributos: nome, idade.
Método: void fazerAniversario()
*/

package questoes;

import objetos.Pessoa;

public class EX01 {

	public static void main(String[] args) {

		Pessoa pessoa1 = new Pessoa("André", 25);

		System.out.print(pessoa1.toString());

		for (int i = 0; i < 5; i++) {

			pessoa1.setIdade(i + 10);
			System.out.print(pessoa1.toString());
		}

	}

}
