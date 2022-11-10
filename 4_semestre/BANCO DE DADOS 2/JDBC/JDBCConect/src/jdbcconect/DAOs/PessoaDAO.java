package jdbcconect.DAOs;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {


    public List<Pessoa> ler() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT * FROM cliente WHERE nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pessoa> pessoas = new ArrayList<>();
        while (rs.next()) {
            Pessoa cliente = new Pessoa(
                    rs.getString("nome"),
                    rs.getString("idade") 
            );
                    
            clientes.add(cliente);
        }
        rs.close();
        conexao.close();

        return pessoas;
    }   
    public void criar(){}
    
}
