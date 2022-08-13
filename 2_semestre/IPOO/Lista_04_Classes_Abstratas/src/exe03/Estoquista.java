package exe03;

public class Estoquista extends Funcionario {

	int deposito;
	
	public Estoquista(String nome, double salario, int deposito) {
		super(nome, salario);
		this.deposito = deposito;
	}

	public int getDeposito() {
		return deposito;
	}

	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}

	@Override
	public String toString() {
		return "\nEstoquista \nNúmero do deposito = " + deposito + "\nNome ="  + nome + "\nSalário do funcionário = " + salarioLiquido();
	}
	
	
	
}
