package exe03;

public abstract class Gerente extends Funcionario {

	public Gerente(String nome, double salario) {
		super(nome, salario);
	}
	public Gerente(String nome) {
		super(nome);
	}

	public double fundoReservaGerente() {
		return salarioBruto() * 0.02;
	}
	
	public double salarioLiquidoGerente() {
		return salarioLiquido() - fundoReservaGerente();
	}
	
}
