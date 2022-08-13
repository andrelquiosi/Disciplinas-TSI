/*Escreva um programa que leia dois vetores X e Y, cada um contendo 5 posições. Crie
três novos vetores V, W e Z, sendo V = A – B, W = B – A e Z = A + B. Mostrar os vetores
resultantes. Calcule também o produto escalar X * Y ( = X[0]*Y[0]+X[1]*Y[1]+…)*/

package lista01;

import java.util.*;

public class exe20 {

	public static void main(String[] args) {

		int x[] = new int[5];
		int y[] = new int[5];

		x = random(x);
		y = random(y);

		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));

		int v[] = uniao(x, y);
		int w[] = uniao(y, x);
		int z[] = intersecao(x, y);
		int prodEscalar[] = produtoEscalar(x, y);

		System.out.println(Arrays.toString(v));
		System.out.println(Arrays.toString(w));
		System.out.println(Arrays.toString(z));
		System.out.println(Arrays.toString(prodEscalar));

	}

	public static int[] produtoEscalar(int A[], int B[]) {

		int resultado[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			resultado[i] = A[i] * B[i];
		}
		return resultado;
	}

	public static int[] intersecao(int A[], int B[]) {
		int tam = A.length < B.length ? A.length : B.length;
		int resp[] = new int[tam];
		int cont = 0;
		for (int a : A) {
			if (existe(a, 0, B.length - 1, B)) {
				resp[cont++] = a;
			}
		}
		if (cont == 0) {
			return null;
		}
		int aux[] = new int[cont];
		for (int i = 0; i < cont; i++) {
			aux[i] = resp[i];
		}
		return aux;
	}

	public static boolean existe(int num, int ini, int fim, int vet[]) {
		if (ini < 0 || ini >= vet.length || fim >= vet.length) {
			return false;
		}
		for (int p = ini; p <= fim; p++) {
			if (vet[p] == num) {
				return true;
			}
		}
		return false;
	}

	public static int[] uniao(int array1[], int array2[]) {
		int resp[] = new int[array1.length + array2.length];
		int cont = 0;
		for (int x : array1) {
			resp[cont++] = x;
		}
		
		for (int x : array2) {
			if (!existe(x, 0, array1.length - 1, array1)) {
				resp[cont++] = x;
			}
		}

		int aux[] = new int[cont];
		for (int i = 0; i < cont; i++) {
			aux[i] = resp[i];
		}
		return aux;
	}

	public static int[] random(int array[]) {// Gera números aleatórios
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10); // Gera números aleatórios com limite 10.
		}
		return array;
	}

}
