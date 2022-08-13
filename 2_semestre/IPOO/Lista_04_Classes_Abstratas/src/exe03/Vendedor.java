package exe03;

public class Vendedor extends Funcionario {
	String setor;
	
	public Vendedor(String nome, double salario, String setor) {
		super(nome, salario);
		this.setor = setor;
	}

	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}


	@Override
	public String toString() {
		return "Vendedor \nSetor = " + setor + "\nNome do funcionário = " + nome + "\nSalário = R$" + salarioLiquidoVendedor();
	}
	
}
