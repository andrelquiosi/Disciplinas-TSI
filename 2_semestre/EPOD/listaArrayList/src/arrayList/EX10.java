/*10. Escreve um programa para gerar um ArrayList com N elementos gerados de forma aleatória.
(a) geraInteiro(n, min, max) retorna um ArrayList com n inteiros (distribuídos uniformemente)—
cada inteiro está entre min e max.
(b) geraDouble(n, min, max) retorna um ArrayList com n doubles (distribuídos uniformemente)—
cada double está entre min e max.
(c) geraString(n, t) retorna um ArrayList com n Strings de comprimento t.*/

package arrayList;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;

public class EX10 {

	public static void main(String[] args) {

		int n = 10;
		int min = 2;
		int max = 8;
		int t = 4;

		ArrayList<Integer> listaInt = new ArrayList<>(geraInteiro(n, min, max));
		ArrayList<Double> listaDouble = new ArrayList<>(geraDouble(n, min, max));
		ArrayList<String> listaString = new ArrayList<>(geraString(n, t));
		 
		

		System.out.println(listaInt);
		System.out.println(listaDouble);
		System.out.println(listaString);
		
	}
	public static ArrayList<String> geraString(int n, int t) {
	    ArrayList<String> string = new ArrayList<>();
		
		byte[] array = new byte[t]; 
	    new Random().nextBytes(array);
	    String geraString = "";

		for (int i = 0; i < n; i++) {			
			geraString = new String(array, Charset.forName("UTF-8"));
			string.add(geraString);
		}
	    
		return string;
	}

	public static ArrayList<Integer> geraInteiro(int n, int min, int max) {

		ArrayList<Integer> lnteiro = new ArrayList<>();
		Random random = new Random();
		int r;
		for (int i = 0; i < n;) {			
			if ( (r = random.nextInt(max)) > min) {
					lnteiro.add(r);
					i++;
			}

		}
		return lnteiro;

	}
	public static ArrayList<Double> geraDouble(int n, double min, double max) {
		
		ArrayList<Double> doub = new ArrayList<>();
		Random random = new Random();
		double r = 0.0;
		
		
		for (int i = 0; i < n;i++) {	
			r = min + new Random().nextDouble() * (max - min);
				doub.add(r);
				
			}
			
		
		return doub;
		
	}

}
