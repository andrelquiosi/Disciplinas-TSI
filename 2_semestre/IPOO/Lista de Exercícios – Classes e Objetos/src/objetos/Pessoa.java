package objetos;

public class Pessoa {

	String nome;
	int idade;
	
	public Pessoa(String nome, int idade){
		this.idade = idade;
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}



	void fazerAniversario() {

	}

	@Override
	public String toString() {
		return "Pessoa\nNome: " + nome + ", Idade: " + idade;
	}

}
