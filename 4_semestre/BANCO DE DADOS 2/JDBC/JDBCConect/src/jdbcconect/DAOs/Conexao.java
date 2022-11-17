package jdbcconect.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private final String database ="aula12";
    private final String user ="aluno";
    private final String password ="teste$123";
    private final String host = "localhost";

    public Connection getConexao(){
        try {
            return DriverManager.getConnection("jdbc:mysql://"+host+"/"+database+"?"
                    + "user="+user+"&password="+password);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return null;
        
    }
}
