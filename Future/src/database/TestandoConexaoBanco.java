package database;

import java.sql.Connection;
import java.sql.SQLException;

public class TestandoConexaoBanco {
    public static void main(String[] args) {
        try {
            // Tentar obter a conexão com o banco de dados
            Connection connection = ConexaoBanco.getConnection();

            // Se a conexão for bem-sucedida, imprimir uma mensagem
            if (connection != null) {
                System.out.println("Conexão bem-sucedida!");
                connection.close(); // Não se esqueça de fechar a conexão depois de usá-la
            }
        } catch (SQLException e) {
            // Se ocorrer algum erro, exibir a mensagem de erro
            System.out.println("Erro na conexão: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
