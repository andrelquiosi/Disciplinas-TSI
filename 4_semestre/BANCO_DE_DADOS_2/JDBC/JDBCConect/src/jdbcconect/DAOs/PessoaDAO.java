package jdbcconect.DAOs;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class PessoaDAO {

    public static List<Pessoa> ler(String nome) throws SQLException {
        List<Pessoa> pessoas;
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "SELECT * FROM pessoas WHERE nome like ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                pessoas = new ArrayList<>();
                while (rs.next()) {
                    Pessoa pessoa;
                    pessoa = new Pessoa(
                            rs.getString("nome"),
                            rs.getInt("idade")
                    );
                    
                    pessoas.add(pessoa);
                }
            }
        }

        return pessoas;
    }

    public static void criar(Pessoa pessoa) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "insert into pessoas (nome,idade) value (?,?)";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, pessoa.getNome());
                ps.setInt(2, pessoa.getIdade());
                
                ps.execute();
            }
        }
    }

    public static void atualizar(String nome, Pessoa pessoa) throws SQLException {

        String sql = "UPDATE pessoas SET nome = ?, idade = ? WHERE nome = ?";

        try (Connection conexao = new Conexao().getConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setString(3, nome);
            
            ps.execute();
        }

    }

    public static void remover(String nome) throws SQLException {
        try (Connection conexao = new Conexao().getConexao()) {
            String sql = "DELETE FROM pessoas WHERE nome = ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, nome);
                ps.executeUpdate();
            }
        }
    }

}
