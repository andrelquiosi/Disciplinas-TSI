/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Atividades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author aluno
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println(Files.readAllLines(Paths.get("src/Atividades/br-sem-acentos.txt"))
                .stream()
                .filter(palavra -> palavra.length() < 5 && palavra.startsWith("a"))
                .collect(Collectors.toList()));
    }

}
