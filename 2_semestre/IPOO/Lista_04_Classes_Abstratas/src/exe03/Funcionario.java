package exe03;

public abstract class Funcionario {
	String nome;
	double salario;

	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double salarioBruto() {
		return salario;
	}

	public double salarioLiquido() {
		return salarioBruto() - descontoINSS();
	}

	public double salarioLiquidoVendedor() {
		return salarioLiquido() - fundoReservaVendedor();
	}

	public double descontoINSS() {
		return salarioBruto() * 0.08;
	}

	public double fundoReservaVendedor() {
		return salarioBruto() * 0.015;
	}

}
