package objetos;

public class Retangulo {

	private double base, altura, posicaoX, posicaoY;

	public Retangulo(double base, double altura, double posicaoX, double posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.base = base;
		this.altura = altura;
	}

	public double getPosicaoX() {

		return posicaoX;
	}

	public double getPosicaoY() {

		return posicaoY;
	}

	public static double distanciaEntrePontos(Retangulo a, Retangulo b) {
		double distancia = Math
				.sqrt(Math.pow(b.getPosicaoX() - a.getPosicaoX(), 2) 
						+ Math.pow(b.getPosicaoY() - a.getPosicaoY(), 2));
		return distancia;

	}

	public double areaRetangulo(double base, double altura) {
		return this.base * this.altura;
	}

}
