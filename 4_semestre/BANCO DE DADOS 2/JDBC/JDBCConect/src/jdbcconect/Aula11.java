package jdbcconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author andre
 */
public class Aula11 {
    
    
    
    public static void main(String[] args) {
    Connection conn  = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?" +
                                                "user=aluno&password=teste$123");
            System.out.println("Connectado");
        } catch (SQLException e) {
            System.out.println("SQLException: "+ e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " +e.getErrorCode());
        }
    }

}
