package objetos;

public class Ponto {

	double x, y;

	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getPontoX() {

		return x;
	}

	public double getPontoY() {

		return y;
	}

	public static double distancia(Ponto a, Ponto b) {
		double distancia = Math
				.sqrt(Math.pow(b.getPontoX() - a.getPontoX(), 2) 
						+ Math.pow(b.getPontoY() - a.getPontoY(), 2));
		return distancia;

	}

}
