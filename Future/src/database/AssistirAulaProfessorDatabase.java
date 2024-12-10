package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssistirAulaProfessorDatabase {
    public String[][] buscarDadosAulas(String nomeUsuario) {
        String[][] aulasData = new String[5][4];  // 5 dias, 4 informações por dia
    
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT b.dia, b.materia, b.horarioinicio, b.horariofim, b.linkSaladeAula " +
                         "FROM usuarios AS a " +
                         "LEFT JOIN aulas AS b ON a.IdMateria = b.IdMateria " +
                         "WHERE a.usuario = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                String diaSemana = rs.getString("dia"); // Lê o nome do dia da semana (como "Segunda", "Terça", etc.)
                int dia = diaParaIndice(diaSemana);  // Converte o nome do dia para o índice (0 a 4)
    
                if (dia != -1) {  // Se o dia for válido (de segunda a sexta)
                    aulasData[dia][0] = rs.getString("materia");
                    aulasData[dia][1] = rs.getString("horarioinicio");
                    aulasData[dia][2] = rs.getString("horariofim");
                    aulasData[dia][3] = rs.getString("linkSaladeAula");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return aulasData;
    }
    
    // Método para mapear o nome do dia para o índice correto (0 a 4)
    private int diaParaIndice(String diaSemana) {
        switch (diaSemana.toLowerCase()) {
            case "segunda":
                return 0;
            case "terça":
                return 1;
            case "quarta":
                return 2;
            case "quinta":
                return 3;
            case "sexta":
                return 4;
            default:
                return -1;  // Caso o dia não seja válido (não seja de segunda a sexta)
        }
    }
}
