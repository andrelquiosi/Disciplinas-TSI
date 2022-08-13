package objetos;

public class Funcionario {

	private String nome, setor;
	private double salario;
	private int matricula;

	public Funcionario(int matricula, String nome, String setor, double salario) {
		if (matricula > 0 && (setor == "A" || setor == "B" || setor == "C" || setor == "D")) {
			this.matricula = matricula;
			this.nome = nome;
			this.setor = setor;
			this.salario = salario;
		}
	}

	public String getNome() {
		return nome;
	}

	public String getSetor() {
		return setor;
	}

	public double getSalario() {
		return salario;
	}

	public int getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", setor=" + setor + ", salario=" + salario + ", matricula=" + matricula
				+ "]";
	}

	public Funcionario reajuste(Funcionario f) {
		if(f != null) {
			//SETOR "A"
			if(f.getSetor() == "A" && f.getSalario() <= 2499.99) {
				salario = salario * 0.08 + salario;
			}
			if(f.getSetor() == "A" && f.getSalario() >= 2500.00 && f.getSalario() < 4999.99) {
				salario = salario * 0.07 + salario;
			}
			if(f.getSetor() == "A" && f.getSalario() > 5000.00) {
				salario = salario * 0.06 + salario;
			}
			//SETOR "B"
			if(f.getSetor() == "B" && f.getSalario() <= 2499.99) {
				salario = salario * 0.10 + salario;
			}
			if(f.getSetor() == "B" && f.getSalario() >= 2500.00 && f.getSalario() < 4999.99) {
				salario = salario * 0.09 + salario;
			}
			if(f.getSetor() == "B" && f.getSalario() > 5000.00) {
				salario = salario * 0.08 + salario;
			}
			//SETOR "C"
			if(f.getSetor() == "C" && f.getSalario() <= 2499.99) {
				salario = salario * 0.11 + salario;
			}
			if(f.getSetor() == "C" && f.getSalario() >= 2500.00 && f.getSalario() < 4999.99) {
				salario = salario * 0.10 + salario;
			}
			if(f.getSetor() == "C" && f.getSalario() > 5000.00) {
				salario = salario * 0.09 + salario;
			}
			//SETOR "D"
			if(f.getSetor() == "D" && f.getSalario() <= 2499.99) {
				salario = salario * 0.12 + salario;
			}
			if(f.getSetor() == "D" && f.getSalario() >= 2500.00 && f.getSalario() < 4999.99) {
				salario = salario * 0.11 + salario;
			}
			if(f.getSetor() == "D" && f.getSalario() > 5000.00) {
				salario = salario * 0.09 + salario;
			}
		}
		
		return f;
		
	}
}
