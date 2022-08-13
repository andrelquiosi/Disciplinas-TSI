package objetos;

public class Tempo {
	
	private int horas,minutos,segundos;

	public Tempo(int horas, int minutos, int segundos) {
if(horas >= 0 && minutos >=0 && minutos <= 60 && segundos >=0 && segundos <= 60)
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	

}
