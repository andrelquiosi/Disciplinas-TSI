/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Produto;


public class ProdutoDAO {
    
    public void inserir(Produto produto){
        String sql= "insert into produto(descricao, preco,categoria_codigo) value (?,?,?)";
        Connection conexao = new Conexao().getConexao();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getCategoria().getCodigo());
            
           ps.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
    
    
}
