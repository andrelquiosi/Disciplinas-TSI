package objetos;

import java.util.ArrayList;

public class Ficha {

	private String nome, cpf, telefone;
	private double limite, saldoDevedor, valorCompra, credito;
	private static int comprasRealizadas, NumeroDaFicha;

	public Ficha(String nome, String cpf, String telefone, double limite) {
		if (nome != null && cpf != null && telefone != null && limite != 0) {
			this.nome = nome;
			this.cpf = cpf;
			this.telefone = telefone;
			this.limite = limite;
			NumeroDaFicha++;
		}
	}

	public Ficha(String nome, String cpf, String telefone, double limite, double valorCompra) {
		if (nome != null && cpf != null && telefone != null && limite != 0 && valorCompra != 0) {
			if (limite >= valorCompra) {

				this.nome = nome;
				this.cpf = cpf;
				this.telefone = telefone;
				this.limite = limite;

				this.valorCompra = valorCompra;

				compraRealizada();
				NumeroDaFicha++;
			}
		}
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {

		if ((limite - saldoDevedor) >= valorCompra) {
			this.valorCompra = valorCompra - credito;
			compraRealizada();
		}
	}

	private void compraRealizada() {
		if ((limite - saldoDevedor) >= valorCompra) {
			this.saldoDevedor = (saldoDevedor + valorCompra) - credito;
			comprasRealizadas++;
		}
	}

	public void setPagamento(double pagamento) {
		if (pagamento > saldoDevedor) {
			this.credito = pagamento - saldoDevedor;
			this.saldoDevedor = 0;
		}else this.saldoDevedor = saldoDevedor - pagamento;
	}

	@Override
	public String toString() {
		return "Ficha: " + NumeroDaFicha + "\nnome= " + nome + "\ncpf= " + cpf + "\ntelefone= " + telefone + "\nlimite= " + limite
				+ "\nsaldoDevedor= " + saldoDevedor + "\nvalorCompra= " + valorCompra + "\ncredito= " + credito
				+ "\ncomprasRealizadas= " + comprasRealizadas+"\n";
	}

}
