package jdbcconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Aula12 {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/aula12?"
                    + "user=aluno&password=teste$123");
            PreparedStatement ps = conn.prepareStatement("SELECT nome, idade FROM pessoa WHERE nome=?");
            ps.setString(1, "bia");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nome") + "\t" + rs.getInt("idade"));

            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

}
