package analise_de_algoritmos;

public class EX02_ElementosDistindos {

	public static void main(String[] args) {
		int[] elementos = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };

		boolean verifica = false;

		for (int i = 0; i < elementos.length - 1; i++) {
			for (int j = i + 1; j < elementos.length; j++) {
				if (elementos[i] == elementos[j]) {
					verifica = true;
					System.out.println(verifica + "" + elementos[i]);
				}
			}

		}
		System.out.println(verifica);
	}

}
