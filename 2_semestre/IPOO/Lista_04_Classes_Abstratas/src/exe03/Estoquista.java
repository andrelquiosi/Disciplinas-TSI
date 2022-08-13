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
		return "\nEstoquista \nN�mero do deposito = " + deposito + "\nNome ="  + nome + "\nSal�rio do funcion�rio = " + salarioLiquido();
	}
	
	
	
}
