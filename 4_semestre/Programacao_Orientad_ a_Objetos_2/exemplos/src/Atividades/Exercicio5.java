/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Atividades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author aluno
 */
public class Exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Files.readAllLines(Paths.get("src/Atividades/br-sem-acentos.txt"))
                .stream()
                .collect(Collectors.groupingBy(palavra -> palavra.substring(0, 1))).forEach((index, list) -> {
            System.out.println(index + " " + list);
        });

    }

}
