
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;


public class CategoriaDAO {
    
    public List<Categoria> buscar(){
        String sql="select * from categoria";
        Connection conexao = new Conexao().getConexao();
        try {
          PreparedStatement ps = conexao.prepareStatement(sql);
            List<Categoria> resultado = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setCodigo(rs.getInt("codigo"));
                categoria.setDescricao(rs.getString("descricao"));
                
                resultado.add(categoria);
            }
            return resultado;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    
    
    
}
