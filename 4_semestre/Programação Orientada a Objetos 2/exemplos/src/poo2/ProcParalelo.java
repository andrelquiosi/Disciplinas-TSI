/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProcParalelo {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    // TODO code application logic here
    public static void main(String[] args) throws IOException {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa pessoa1 = new Pessoa(1, "Andre", 26);
        pessoas.add(pessoa1);
        Pessoa pessoa2 = new Pessoa(6, "Marcos", 27);
        pessoas.add(pessoa2);
        Pessoa pessoa3 = new Pessoa(4, "Felipe", 3);
        pessoas.add(pessoa3);

        try {

            FileOutputStream file = new FileOutputStream("src/poo2/file.txt");

            // Creates an ObjectOutputStream
            ObjectOutputStream output = new ObjectOutputStream(file);

            // writes objects to output stream
            output.writeObject(pessoas);

            // Reads data using the ObjectInputStream
            FileInputStream fileStream = new FileInputStream("src/poo2/file.txt");
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            
            List<Pessoa> list = (ArrayList<Pessoa>)objStream.readObject();
            
            list.forEach(pes -> System.out.println(pes));

            output.close();
            objStream.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }
}
