package arrayList;

import java.util.ArrayList;

public class EX05 {

	public static void main(String[] args) {
		/*
		 * 5. Escreva um método removeDuplicados que recebe como parâmetro uma ArrayList
		 * de Strings e elimina quaisquer duplicatas do ArrayList. Por exemplo:
		 * {"eu","tu", "tu", "ela", "ele", "ele", "eu"} se torna {"eu", "tu", "ela",
		 * "ele"} depois da chamada removeDuplicados(lista).
		 */
		ArrayList<String> lista = new ArrayList<>();

		lista.add("a");
		lista.add("b");
		lista.add("b");
		lista.add("c");
		lista.add("d");
		lista.add("d");
		lista.add("e");
		lista.add("e");
		
		System.out.println(lista);

		System.out.println(removeDuplicados(lista));

	}

	public static ArrayList<String> removeDuplicados( ArrayList<String> lista ) {
		String comparador = "";
		
		for ( int i = 0; i < lista.size(); i++ ) {
			
			comparador = lista.get(i);
			
			System.out.println(comparador);
			
			for ( int j = 0; j < lista.size(); j++ ) {
				
				if ( comparador.equals( lista.get(j) ) ) {
					lista.remove(j);
				}
			}
			
		}

		return lista;

	}

}
