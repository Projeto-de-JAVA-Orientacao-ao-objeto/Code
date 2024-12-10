package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conectar ao banco de dados
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/future", "root", "future2024");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver JDBC não encontrado.");
        }
    }
}

