package lista01;
import java.util.*;
public class exe15 {

	public static void main(String[] args) {
		Scanner src = new Scanner (System.in);
		
		System.out.println("Informe a quantidade de linhas para o Triângulo de Floyd: ");
		int n = src.nextInt();
		
		int soma = 1;
		
		for (int i = 1; i <= n; i++) {
			int cont = 0;
			
			while (cont < i) {
				
				System.out.format("%d ",soma);
				soma = soma + 1;
				cont = cont + 1;
			}
			
			System.out.format("\n");
		}

	}

}
