/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package provapratica.parte1a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class MainA {

    public static void main(String[] args) throws IOException {
        String s = "";
        Scanner sc = new Scanner(new File("LFT_2022.tsv"));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            s += sc.next().replace("%", "").replace(".", "").replace(",", ".");

        }
        sc.close();

        System.out.println(s);
    }

}
