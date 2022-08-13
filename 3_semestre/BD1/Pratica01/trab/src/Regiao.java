import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Regiao {
    
    // atributos de região
    private String id;
    private String nome;
    int k;
    // caminho do arquivo físico Regions.csv
    private static String pathFile = "Regions.csv";
    // vetor de registros de região para lidar na memória
    private static ArrayList<Regiao> regions = new ArrayList();
 

    // método construtor da classe Regiao
    Regiao(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    Regiao() {        
    
    }
    
    // métodos getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // carrega os dados do arquivo físico para a memória
    // atribuindo para manipulação a partir de um vetor de regiões
    static void carregar() {
        try {
            // abre o arquivo Regions.csv para leitura
            BufferedReader br = new BufferedReader(new FileReader(pathFile));                        
            
            String linha = br.readLine();
            linha = br.readLine();
            
            while (linha != null) {
                linha = linha.replaceAll("\"", "");
                String[] fields = linha.split(",");                
                adicionar(new Regiao(fields[0],fields[1]));
                linha = br.readLine();
            }
            
            // fecha o arquivo Regions.csv
            br.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static public void gravar() {        
        try {
            // o arquivo Regions.csv para escrita
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathFile, false));
            
            // grava o cabeçalho
            bw.write("\"id\",\"Name\"\n");
            for (Regiao regiao : Regiao.listar()) {
                // grava cada região do vetor de regiões
                String linha = regiao.getId() + "," + "\"" + regiao.getNome() + "\"\n";
                bw.write(linha);
            }
            
            // fecha o arquivo Regions.csv
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static public void adicionar(Regiao regiao) {        
        regions.add(regiao);
    }
    
    static public Regiao localizar(String id) {        
        for (Regiao regiao : Regiao.listar()) {
            if (regiao.getId().equals(id)) {
                return regiao;
            }   
        }
        return null;
    }
    
    static public void atualizar(Regiao obj) {
        int index = -1;
        
        for (Regiao regiao : Regiao.listar()) {
            index++;
            if (regiao.equals(obj)) {                
                break;
            }
        }
        
        if (index != -1) {
            // atualiza o objetivo da lista a partir do índice
            regions.set(index, obj);
        }
    }
    
    static public void remover(Regiao obj) {
        int index = -1;
        
        for (Regiao regiao : Regiao.listar()) {
            index++;
            if (regiao.equals(obj)) {                
                break;
            }
        }
        
        if (index != -1) {        
            // remover o objetivo da lista a partir do índice
            regions.remove(index);
        }
    }
    
    static public ArrayList<Regiao> listar() {
        return regions;
    }
    
}