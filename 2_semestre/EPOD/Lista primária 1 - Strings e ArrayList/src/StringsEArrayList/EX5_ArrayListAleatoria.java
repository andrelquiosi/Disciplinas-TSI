/*Escreve um programa para gerar um ArrayList com N elementos gerados de forma aleat�ria.
(a) geraInteiro(n, min, max) retorna um ArrayList com n inteiros (distribu�dos uniformemente)�
cada inteiro est� entre min e max.
(b) geraDouble(n, min, max) retorna um ArrayList com n doubles (distribu�dos uniformemente)�
cada double est� entre min e max.
(c) geraString(n, t) retorna um ArrayList com n Strings de comprimento t.*/

package StringsEArrayList;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class EX5_ArrayListAleatoria {

	public static void main(String[] args) {

		int n = 7;
		int min = 7;
		int max = 77;
		int t = 17;

		ArrayList<Integer> listaInt = new ArrayList<>(geraInteiro(n, min, max));
		ArrayList<Double> listaDouble = new ArrayList<>(geraDouble(n, min, max));
		ArrayList<String> listaString = new ArrayList<>(geraString(n, t));

		System.out.println("ArrayList de Inteiros: " + listaInt);
		System.out.println("ArrayList de Double: " + listaDouble);
		System.out.println("ArrayList de String: " + listaString);

	}

	public static ArrayList<Integer> geraInteiro(int n, int min, int max) {

		ArrayList<Integer> lnteiro = new ArrayList<>();

		if (max > min) {

			Random random = new Random();// usa a classe Random para criar um novo objeto random
			int r;

			for (int i = 0; i < n;) {

				if ((r = random.nextInt(max)) > min) {// compara o valor gerado pelo random para ver se � maior que o
														// valor minimo
					lnteiro.add(r);// adiciona o valor gerado no ArrayList inteiro
					i++;// Incrementa o for quando o valor � v�lido
				}
			}
			lnteiro.subList(lnteiro.size()/2, lnteiro.size());

			return lnteiro;

		} else {
			System.out.println("!Valor min maior que o valor max!");
			return lnteiro;
		}
	}

	public static ArrayList<Double> geraDouble(int n, double min, double max) {

		ArrayList<Double> doub = new ArrayList<>();

		if (max > min) {

			Random random = new Random();// usa a classe Random para criar um novo objeto random
			double r = 0.0;

			for (int i = 0; i < n; i++) {
				r = min + new Random().nextDouble() * (max - min);// gera valor aleat�rio entre min e max
				doub.add(r);// adiciona o valor gerado em random no ArrayList doub

			}

			return doub;

		} else {
			System.out.println("!Valor min maior que o valor max!");
			return doub;
		}
	}

	public static ArrayList<String> geraString(int n, int t) {
		
		ArrayList<String> string = new ArrayList<>();
		
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < n; i++) {
			
			StringBuilder builder = null;
			String a = "";

			for (int j = 0; j < t; j++) {

				builder = new StringBuilder();

				int myindex = (int) (alfabeto.length() * Math.random());

				builder.append(alfabeto.charAt(myindex));
				a += builder.toString();//comparar essa operação a string builder
				///gerar 1000 sstrings usar o string builder
				
				
			}

			string.add(a);
		}

		return string;
	}

}
