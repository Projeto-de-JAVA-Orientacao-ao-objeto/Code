package singleton;

import model.CadastrarAulasModel;
import database.CadastrarAulasDatabase;
import java.sql.*;

import javax.swing.JOptionPane;

public class AulaCadastroSingleton {
    private static AulaCadastroSingleton instance;
    private CadastrarAulasDatabase cadastrarAulasDatabase;

    private static final String URL = "jdbc:mysql://localhost:3306/future";
    private static final String USER = "root";
    private static final String PASSWORD = "future2024";

    // Construtor privado
    private AulaCadastroSingleton() {
        this.cadastrarAulasDatabase = new CadastrarAulasDatabase(); // Inicializa o database
    }

    // Método para obter a única instância
    public static synchronized AulaCadastroSingleton getInstance() {
        if (instance == null) {
            instance = new AulaCadastroSingleton();
        }
        return instance;
    }

    // Verifica se a aula já está cadastrada
    public boolean existeAula(String idMateria, String dia, String periodo) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM aulas WHERE IdMateria = ? AND dia = ? AND periodo = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, idMateria);
                stmt.setString(2, dia);
                stmt.setString(3, periodo);

                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    return true; // Aula já cadastrada
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para cadastrar a aula
    public void cadastrarAula(CadastrarAulasModel aula) {
        if (!existeAula(aula.getIdMateria(), aula.getDia(), aula.getPeriodo())) {
            cadastrarAulasDatabase.inserirAula(aula); // Chama o método de inserção
            JOptionPane.showMessageDialog(null, "Aula cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE); // Mensagem de sucesso
        } else {
            JOptionPane.showMessageDialog(null, "Aula já cadastrada para esse horário.", "Erro", JOptionPane.ERROR_MESSAGE); // Mensagem de erro
        }
    }
}
