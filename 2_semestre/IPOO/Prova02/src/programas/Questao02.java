package programas;
import objetos.*;
public class Questao02 {

	public static void main(String[] args) {
		
		 Insumo ins[] = new Insumo[4]; 
		 InsumoImportado.setCotacaoDolar(5.45);
		 ins[0] = new Insumo(23, "Madeira 15x15", 143.44); 
		 ins[1] = new InsumoImportado(31, "Junta Titânio", 459.09, 142.15, "Polônia");
		 ins[2] = new Insumo(13, "Chapa Aluminio 5mm", 830.99);
		 ins[3] = new InsumoImportado(8,"Rolamento Fibra Carbono", 230.00, 83.13, "EUA");
		 for (int i = 0; i < 4; i++) {
		 System.out.format("Insumo %s – Impostos: %.2f – Custo Total: %.2f\n",
		 ins[i].getDescricao(), ins[i].calcularImpostos(),
		 ins[i].calcularCustoTotal());
		 }
	}

}
