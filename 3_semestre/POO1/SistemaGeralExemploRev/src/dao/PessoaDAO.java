
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Pessoa;


public class PessoaDAO {
    
    public void adicionar(Pessoa pessoa)throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql="insert into pessoa (descricao,cep,bairro, numero) value (?,?,?,?)";
        PreparedStatement ps=conexao.prepareStatement(sql);
        ps.setString(1, pessoa.getDescricao());
         ps.setString(2, pessoa.getCep());
         ps.setString(3, pessoa.getBairro());
         ps.setInt(4, pessoa.getNumero());
         ps.execute();
         ps.close();
         conexao.close();
    }
    
    public void remover(int codigo)throws SQLException{
        Connection conexao = new Conexao().getConexao();
        String sql="delete from pessoa where codigo=?";
         PreparedStatement ps=conexao.prepareStatement(sql);
         ps.setInt(1, codigo);
         ps.executeUpdate();
         ps.close();
         conexao.close();
         
        
    }
    
    public void alterar(Pessoa pessoa)throws SQLException{
      
        Connection conexao = new Conexao().getConexao();
        String sql="UPDATE pessoa set descricao=?,cep=?,bairro=?,numero=?"
                +" where codigo=?";
        PreparedStatement ps=conexao.prepareStatement(sql);
        ps.setString(1, pessoa.getDescricao());
         ps.setString(2, pessoa.getCep());
         ps.setString(3, pessoa.getBairro());
         ps.setInt(4, pessoa.getNumero());
         ps.setInt(5, pessoa.getCodigo());
         ps.executeUpdate();
         ps.close();
         conexao.close();

        
        
    }
    
    public List<Pessoa>buscarPelaDescricao(String descricao)throws SQLException{
    Connection conexao = new Conexao().getConexao();
    String sql ="select * from pessoa where descricao like ?";
    PreparedStatement ps = conexao.prepareStatement(sql);
    ps.setString(1, "%"+ descricao + "%");
     ResultSet rs = ps.executeQuery();
     List<Pessoa> pessoas = new ArrayList<>();
     while(rs.next()){
         Pessoa pessoa = new Pessoa(rs.getString("descricao"),
         rs.getString("cep"), rs.getString("bairro"),rs.getInt("numero"),
                 rs.getInt("codigo"));
         
         pessoas.add(pessoa);
     }
      rs.close();
       ps.close();
      conexao.close();
     
      return pessoas;
}
    
}
