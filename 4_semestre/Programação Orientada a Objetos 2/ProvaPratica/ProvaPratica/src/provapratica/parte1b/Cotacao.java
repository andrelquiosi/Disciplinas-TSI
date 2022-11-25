package provapratica.parte1b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Cotacao implements Serializable {

    private String dia;
    private float taxaCompraManha, taxaVendaManha, puCompraManha, puVendaManha, puBaseManha;
    private static String vencimento;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<Cotacao> cotacao = new ArrayList<>();
        Cotacao cot = new Cotacao();

        String[] s;
        Scanner sc = new Scanner(new File("LFT_2022.tsv"));

        Cotacao.setVencimento(sc.nextLine().split("\t")[1]);
        sc.nextLine();
        while (sc.hasNextLine()) {

            s = sc.nextLine().replace("%", "").replace(".", "").replace(",", ".").split("\t");
            cotacao.add(new Cotacao(s[0], Float.parseFloat(s[1]), Float.parseFloat(s[2]), Float.parseFloat(s[3]), Float.parseFloat(s[4]), Float.parseFloat(s[5])));

        }
        sc.close();

        FileOutputStream fos = new FileOutputStream("ColecaoCotacaoLTF22.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(cotacao);

        oos.close();

    }

    public Cotacao() {
    }

    public Cotacao(String dia, float taxaCompraManha, float taxaVendaManha, float puCompraManha, float puVendaManha, float puBaseManha) {
        this.dia = dia;
        this.taxaCompraManha = taxaCompraManha;
        this.taxaVendaManha = taxaVendaManha;
        this.puCompraManha = puCompraManha;
        this.puVendaManha = puVendaManha;
        this.puBaseManha = puBaseManha;
    }

    public static String getVencimento() {
        return vencimento;
    }

    public static void setVencimento(String venvcimento) {
        Cotacao.vencimento = venvcimento;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public float getTaxaCompraManha() {
        return taxaCompraManha;
    }

    public void setTaxaCompraManha(float taxaCompraManha) {
        this.taxaCompraManha = taxaCompraManha;
    }

    public float getTaxaVendaManha() {
        return taxaVendaManha;
    }

    public void setTaxaVendaManha(float taxaVendaManha) {
        this.taxaVendaManha = taxaVendaManha;
    }

    public float getPuCompraManha() {
        return puCompraManha;
    }

    public void setPuCompraManha(float puCompraManha) {
        this.puCompraManha = puCompraManha;
    }

    public float getPuVendaManha() {
        return puVendaManha;
    }

    public void setPuVendaManha(float puVendaManha) {
        this.puVendaManha = puVendaManha;
    }

    public float getPuBaseManha() {
        return puBaseManha;
    }

    public void setPuBaseManha(float puBaseManha) {
        this.puBaseManha = puBaseManha;
    }

}
