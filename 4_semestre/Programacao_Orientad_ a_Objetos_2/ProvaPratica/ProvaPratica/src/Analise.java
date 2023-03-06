/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import provapratica.parte1c.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import provapratica.parte1b.Cotacao;

/**
 *
 * @author andre
 */
public class Analise {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("ColecaoCotacaoLTF22.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Cotacao> cotacao = (ArrayList<Cotacao>) ois.readObject();

        ois.close();
        
        
        cotacao.stream().forEach(t -> System.out.println(t.getPuVendaManha()));
        System.out.println(cotacao.stream().count());
        System.out.println("O valor maximo da taxa de compra é:" + cotacao.stream().map(t -> t.getTaxaCompraManha()).max((a, b) -> a.compareTo(b)).get());
        cotacao.parallelStream().filter(a-> (a.getPuCompraManha() - a.getPuVendaManha()) > 6.8).forEach(System.out::print);
        cotacao.stream().map(t -> t.getPuBaseManha() + 0.05);
    }

}
