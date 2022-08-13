/*4. Escreva um programa Java para armazenar o conte�do do arquivo de texto em estruturas
ArrayList. Cada token (palavra, numero, espa�o) deve ser uma String. Cada linha do
arquivo � um ArrayList de Strings. O arquivo � representado por um ArrayList com os
ArrayList de String de cada linha.
(a) Escreva um programa para ler um arquivo .txt e popular as estruturas ArrayList.
(b) Implemente um m�todo imprime, que imprime o conte�do dos ArrayLists em tela,
de modo que a apresenta��o fique como a contida no arquivo texto.
(c) Escreva um m�todo, tornaMaiusculo, que transforma todo o conte�do das ArrayLists
para palavras com letras mai�sculas.
*/

package StringsEArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class EX4_txtArrayList {

	public static void main(String[] args) throws Exception {

		File file = new File("/src/exemplo.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		ArrayList<ArrayList<String>> arrayListDoTXT = new ArrayList<ArrayList<String>>();

		while ((st = br.readLine()) != null) {

			ArrayList<String> subArrayList = new ArrayList<String>(Arrays.asList(st.split(" ")));//separa a linha do txt por palavras e coloca dentro da subArrayList
			
			for (int i = subArrayList.size() - 1; i > 0; i--) {//percorre a subArrayList
	
				subArrayList.add(i, " ");// adiciona o espa�o entre as palavras da subArrayList
			}
			arrayListDoTXT.add(subArrayList);//coloca a subArrayList dentro da arrayListDoTXT

		}

//		Imprime(arrayListDoTXT);
		
//		TornaMaiusculo(arrayListDoTXT);
		
	//	System.out.println(arrayListDoTXT);
		
	//	Imprime(arrayListDoTXT);

	}

	public static void Imprime(ArrayList<ArrayList<String>> arrayListDoTXT) {
		
		for (int i = 0; i < arrayListDoTXT.size(); i++) {//percorre a Arraylist arrayListDoTXT

			for (int j = 0; j < arrayListDoTXT.get(i).size(); j++) {//percorre as Arraylist  dentro da arrayListDoTXT

				System.out.print(arrayListDoTXT.get(i).get(j));
			}
			
			System.out.println();
		}

	}
	public static ArrayList<ArrayList<String>> TornaMaiusculo(ArrayList<ArrayList<String>> arrayListDoTXT) {
		
		ArrayList<String> subArrayList;// ArrayList auxiliar
		
		for (int i = 0; i < arrayListDoTXT.size(); i++) {//percorre a Arraylist arrayListDoTXT
			
			subArrayList = new ArrayList<>();
			
			for (int j = 0; j < arrayListDoTXT.get(i).size(); j++) {//percorre as Arraylist  dentro da arrayListDoTXT
				
				String auxiliar = arrayListDoTXT.get(i).get(j).toUpperCase();//pega a posi��o dentro da arrayListDoTXT e coloca na auxiliar como UpperCase
								
				subArrayList.add(auxiliar);//adiciona a auxiliar dentro da subArrayList
												
			}
			
			arrayListDoTXT.set(i, subArrayList);//coloca a subArrayList dentro da posi��o [i] da arrayListDoTXT
			
		}
		
		
		return arrayListDoTXT;
		
	}

}
