package objetos;

import java.util.Objects;

public class Aluno {

	private String nome;
	private String ra;
	private String nascimento;
	private double coeficiente;

	public Aluno(String ra, String nome, String nascimento, double coeficiente) {
		
		this.ra = ra;
		this.nome = nome;
		this.nascimento = nascimento;
		this.coeficiente = coeficiente;

	}


	public String getNome() {
		return nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public String getRa() {
		return ra;
	}

	public double getCoeficiente() {
		return coeficiente;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}

	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", ra=" + ra + ", nascimento=" + nascimento + ", coeficiente=" + coeficiente
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coeficiente, nascimento, nome, ra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Double.doubleToLongBits(coeficiente) == Double.doubleToLongBits(other.coeficiente)
				&& Objects.equals(nascimento, other.nascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(ra, other.ra);
	}



	


}
