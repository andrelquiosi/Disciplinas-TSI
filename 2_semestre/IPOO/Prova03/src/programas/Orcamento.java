package programas;

import questao1.Imposto;
import questao1.ItemOrcamento;
import questao1.Produto;
import questao1.Servico;

public class Orcamento {

	public static void main(String[] args) {
		
		ItemOrcamento itens[] = new ItemOrcamento[3];
		itens[0] = new Produto("Gasolina Aditivada", 5.80, 500);
		itens[1] = new Servico("Jurandir (paisagista)", 30, 27.50);
		itens[2] = new Imposto("INSS sobre pagamentos", 235000.00, 6.5);
		
		listarOrcamento(itens);

	}
	
	public static void listarOrcamento(ItemOrcamento it[]) {
		
		double total = 0;
		
		for (ItemOrcamento item : it) {
			System.out.print(item.getDescricao());
			System.out.printf(" Total R$%.2f \n", item.getValor());
			total += item.getValor();
		}
		System.out.printf("Valor final do projeto = R$%.2f",total);

	}

}
