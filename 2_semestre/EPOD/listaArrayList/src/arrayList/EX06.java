package arrayList;

import java.util.ArrayList;

public class EX06 {

	public static void main(String[] args) {
		/*
		 * 6. Escreva um método filtraIntervalos que recebe um ArrayList de inteiros e
		 * dois valores inteiros min e max como parâmetros e remove todos os elementos
		 * cujos valores estão no intervalo min a max(inclusive) da lista.
		 */
		ArrayList<Integer> inteiros = new ArrayList<>();	
		
		inteiros.add(45);//0
		inteiros.add(65);//1
		inteiros.add(85);//2
		inteiros.add(95);//3
		inteiros.add(75);//4
		
		int min = 0;
		int max = 3;
		
		System.out.println(inteiros);
		filtraIntervalos(inteiros, min, max);
		System.out.println(inteiros);
	}
	
	public static void filtraIntervalos(ArrayList<Integer> lista, int min, int max) {
		 
		if(min >=0 && max <= lista.size()) {			
		lista.subList(min, max+1).clear();//cria uma subList com o intervalo de valores e depois deleta ela
		}else {
			System.out.printf("Intervalo %d a %d inválido!! Deve ser entre 0 e %d(Tamano maximo da ArrayList)\n",min,max, lista.size());
		}
		
	}

}
