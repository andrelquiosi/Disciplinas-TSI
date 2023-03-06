/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author aluno
 */
public class NewClass {

    public static void printInteger(Integer i) {
        System.out.println(i);
    }

    public static void main(String[] args) {

//        String[] arr = new String[]{"a", "b", "c"};;
//        Stream<String> stream = Arrays.stream(arr);
//
//        ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
//        Stream<String> stream2 = list.stream();
//
//        stream = Stream.of("a", "b", "c");
//
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//
//        numbers.forEach((n) -> {
//            System.out.println(n);
//        });

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            list.add(i);
        }
        
        list.forEach(element -> printInteger(element));
        
        list.parallelStream().forEach(element -> printInteger(element));
        
        

    }
}
