package arrayList;

import java.util.ArrayList;

public class EX08 {

	public static void main(String[] args) {
		/*
		 * 8. Escreva um m�todo chamado espelha que receba um ArrayList de Strings como
		 * par�metro e produza uma c�pia espelhada da lista como sa�da. Dessa forma, os
		 * valores originais s�o seguidos por esses mesmos valores na ordem oposta. Por
		 * exemplo: ["carro", "de", "caminhao"] se torna ["carro", "de",
		 * "caminhao","caminhao", "de","carro"] depois de uma chamada espelha(lista).
		 */
		
		ArrayList<String> lista = new ArrayList<>();
		
		lista.add("Carro");
		lista.add("de");
		lista.add("Caminh�o");
		
		System.out.println(lista);
		
		espelha(lista);
		
		System.out.println(lista);
			
	}

	private static void espelha(ArrayList<String> lista) {
		int i = lista.size();//armazena o tamanho da lista antes da altera��o
		for(i = i; i > 0; i--) {//percorre a lista de tr�s pra frente
			lista.add(lista.get(i-1));//adiciona os valores de tr�s pra frente na lista
		}
		
	}
	

}
