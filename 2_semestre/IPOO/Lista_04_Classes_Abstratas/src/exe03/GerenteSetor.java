package exe03;

public class GerenteSetor extends Gerente {

	double bonificacao;
	
	public GerenteSetor(String nome, double salario, double bonificacao) {
		super(nome, salario);
		this.bonificacao = bonificacao;
	}
	public GerenteSetor(String nome, double bonificacao) {
		super(nome);
		this.bonificacao = bonificacao;
	}

	public double getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}
	
	
	public double salarioGerenteSetor() {
		return salarioLiquidoGerente() + bonificacao;
	}

	@Override
	public String toString() {
		return "\nGerente de Setor \nBonificação = " + bonificacao + "\nNome = " + nome + "\nSalário = " + salario;
	}

	
}
