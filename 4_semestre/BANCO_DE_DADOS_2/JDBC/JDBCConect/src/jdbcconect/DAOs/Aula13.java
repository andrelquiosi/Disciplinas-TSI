/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbcconect.DAOs;

import java.sql.SQLException;

public class Aula13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {


        System.out.println("Criando nova pessoa...");
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Marcos");
        pessoa.setIdade(34);

        System.out.println("Salvando " + pessoa.getNome());
        PessoaDAO.criar(pessoa);

        pessoa = null;

        System.out.println("Recuperando pessoa:  ");
        pessoa = (Pessoa) PessoaDAO.ler("Marcos");
        System.out.println(pessoa.getNome()  + ", Idade: " + pessoa.getIdade());
        

        pessoa.setNome("Marcos Silva");
        
        System.out.println("Editando " + pessoa.getNome() + " para " + pessoa.getNome());
        PessoaDAO.atualizar("Marcos Silva", pessoa);

        System.out.println("Deletando " + pessoa.getNome());
        PessoaDAO.remover("Marcos Silva");
        
        
        
    }
    
}
