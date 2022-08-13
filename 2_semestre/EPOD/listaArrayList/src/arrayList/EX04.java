package arrayList;

import java.util.ArrayList;

import objetos.Aluno;

public class EX04 {

	public static void main(String[] args) {
		/*
		 * 4. Escreva um programa Java para pesquisar um elemento em um ArrayList. (a)
		 * Reescreva o programa, mas sem usar o método definido no JDK, isto é, utilize
		 * um laço para percorrer e encontrar o elemento no ArrayList.
		 */

		ArrayList<String> nome = new ArrayList<>();// cria uma ArrayList
		
		nome.add("felipe");//0
		nome.add("127");//1
		nome.add("andre");//2
		nome.add("marcos");//3
		nome.add("batatinha");//4

		int ondeEsta = nome.indexOf("127");//procura dentro da ArrayList 
		
		System.out.println(nome.get(ondeEsta) + " Está na posição " + ondeEsta + " de 0 a "+ ( nome.size()-1) );
	
		/////////////////////////////////////////////////////////////////////
		 String achei = "andre";
		
         for ( int i = 0; i < nome.size(); i++ ) {
        	 
             if ( achei.equals( nome.get(i) ) ) {
            	 System.out.println( nome.get(i) + " Está na posição " + i + " de 0 a "+ ( nome.size()-1) );
             }
         }
		
		

	}

}
