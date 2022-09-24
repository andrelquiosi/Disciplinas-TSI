/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Atividades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Exercicio1 {

    public static void main(String[] args) throws IOException {

        //PALINDROMOS
        Files.readAllLines(Paths.get("src/Atividades/br-sem-acentos.txt"))
                .stream()
                .filter(palavra -> palavra.equals(new StringBuilder(palavra).reverse().toString()))
                .forEach(System.out::println);


    }

}
