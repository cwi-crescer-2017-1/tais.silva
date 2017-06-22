package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author carloshenrique
 */
public class ExemploSelect {

    public static void main(String[] args) {
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "crescer";
        final String pass = "crescer";

        final String query = "SELECT * FROM PAIS";

        try (final Connection connection = DriverManager.getConnection(url, user, pass);
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("SIGLA"));
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
    }

}
