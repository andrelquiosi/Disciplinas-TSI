package arrayList;

import java.util.ArrayList;

public class EX02 {

	public static void main(String[] args) {//-----------------------------------
		/*
		 * 2. Escreva um programa Java para inserir um elemento em uma ArrayList de
		 * inteiros na: primeira posi��o do Arraylist; �ltima posi��o do Arraylist;
		 * posi��o espec�fica (dada por um �ndice qualquer ) do Arraylist�verifique se o
		 * �ndice � valido.
		 */
		int indice = 7;
		ArrayList<Integer> inteiros = new ArrayList();

		inteiros.add(0, 10);
		inteiros.add(1, 7);
		inteiros.add(inteiros.size(), 4);
		
		//inteiros.add(indice, 7);

		System.out.println(inteiros);

	}

}
