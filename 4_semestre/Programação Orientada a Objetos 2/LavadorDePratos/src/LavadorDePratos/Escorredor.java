package LavadorDePratos;

public class Escorredor {

    private Prato pratos[];
    private int tamanho;
    private int colocaPrato, pegaPrato, count;

    public Escorredor(int tamanho) {
        this.tamanho = tamanho;
        this.pratos = new Prato[tamanho];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == tamanho;
    }

    public Prato pega() {

        Prato temp = pratos[pegaPrato];
        if (++pegaPrato == tamanho) {
            pegaPrato = 0;
        }
        if (--count == 0) {
            System.out.println("Escorredor está vazio!");
        }
        return temp;
    }

    public void coloca(Prato p) {

        pratos[colocaPrato] = p;
        if (++count == tamanho) {
            System.out.println("Escorredor está cheio!");
        }
        if (++colocaPrato == tamanho) {
            colocaPrato = 0;
        }
    }

}
