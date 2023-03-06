package LavadorDePratos;

public final class Prato {

    private int numero_de_serie;
    private Estado nivel_de_sujeira;

    public Prato(int numero_de_serie, Estado nivel_de_sujeira) {
        this.numero_de_serie = numero_de_serie;
        this.nivel_de_sujeira = nivel_de_sujeira;
    }

    public int getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(int numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }

    public Estado getNivel_de_sujeira() {
        return nivel_de_sujeira;
    }

    public void setNivel_de_sujeira(Estado nivel_de_sujeira) {
        this.nivel_de_sujeira = nivel_de_sujeira;
    }

}
