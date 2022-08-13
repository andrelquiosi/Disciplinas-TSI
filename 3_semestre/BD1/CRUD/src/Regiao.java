
public class Regiao {

    // atributos de região
    private int id;
    private String nome;
    private boolean emUso;

    // método construtor da classe Regiao
    Regiao(int id, String nome, boolean emUso) {
        this.id = id;
        this.nome = nome;
        this.emUso = emUso;

    }
    Regiao(){
        
    }

    // métodos getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = "\""+nome+"\"";
    }

    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }
    
}
