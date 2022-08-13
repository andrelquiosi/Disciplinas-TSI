package analise_de_algoritmos;

import java.util.Arrays;

public class EX01_TresConjuntosDisjuntos {

	public static void main(String[] args) {
		
		int[] A = new int[] {1,2,3,4,5};
		int[] B = new int[] {2,4,3,8,10};
		int[] C = new int[] {1,5,8,7,9};
		
		
		System.out.println(distintos(A,B,C));

	

}
	//(a) Escreva um algoritmo cujo pior caso seja O(N³)
	private static boolean distintos(int[] A, int[] B, int[] C) {
	for(int i = 0; i<A.length;i++) {
		for(int j = 0; j<B.length;j++) {
			for(int k = 0; k<C.length;k++) {
				if(A[i] == B[j] && B[j] == C[k])
					return false;
			}
		}
	}
	return true;		
}
}
