package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Conexao;
import modelo.Cliente;

/**
 *
 * @author andre
 */
public class ConsumoDAO {

    public void adicionar(Cliente cliente) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "insert into cliente (nome,sexo,endereco,cep,bairro,cpf,nascimento,data_vencimento,unidade_consumidora,email,kwh,valor_total) value (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSexo());
        ps.setString(3, cliente.getEndereco());
        ps.setString(4, cliente.getCep());
        ps.setString(5, cliente.getBairro());
        ps.setString(6, cliente.getCpf());
        ps.setString(7, cliente.getNascimento());
        ps.setString(8, cliente.getData_vencimento());
        ps.setString(9, cliente.getUnidade_consumidora());
        ps.setString(10, cliente.getEmail());
        ps.setString(11, cliente.getKwh());
        ps.setString(12, cliente.getValor_total());

        ps.execute();
        ps.close();
        conexao.close();

    }

    public void remover(int id_cliente) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, id_cliente);
        ps.executeUpdate();
        ps.close();
        conexao.close();

    }

    public void alterar(Cliente cliente) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "UPDATE cliente SET nome = ?,sexo = ?,endereco = ?,cep = ?,bairro = ?,cpf = ?,nascimento = ?,data_vencimento = ?,unidade_consumidora = ?, email = ?, kwh = ?,valor_total = ?"
                + "WHERE id_cliente = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getSexo());
        ps.setString(3, cliente.getEndereco());
        ps.setString(4, cliente.getCep());
        ps.setString(5, cliente.getBairro());
        ps.setString(6, cliente.getCpf());
        ps.setString(7, cliente.getNascimento());
        ps.setString(8, cliente.getData_vencimento());
        ps.setString(9, cliente.getUnidade_consumidora());
        ps.setString(10, cliente.getEmail());
        ps.setString(11, cliente.getKwh());
        ps.setString(12, cliente.getValor_total());
        ps.setInt(13, cliente.getId_cliente());

    }

    public List<Cliente> buscarPeloNome(String nome) throws SQLException {
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT * FROM cliente WHERE nome like ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();
        List<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
            Cliente cliente = new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"), 
                    rs.getString("unidade_consumidora"),
                    rs.getString("data_vencimento"), 
                    rs.getString("kwh"),
                    rs.getString("valor_total"),
                    rs.getInt("id_cliente")
            );
                    
            clientes.add(cliente);
        }
        rs.close();
        conexao.close();

        return clientes;
    }

}
