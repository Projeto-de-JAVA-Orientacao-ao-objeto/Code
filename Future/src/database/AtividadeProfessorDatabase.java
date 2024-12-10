package database;

import model.AtividadeProfessorModel;
import java.sql.*;

public class AtividadeProfessorDatabase {
    public AtividadeProfessorModel buscarDadosProfessor(String nomeUsuario) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT IdMateria, Materia, Nome FROM usuarios WHERE usuario = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new AtividadeProfessorModel(
                        rs.getString("IdMateria"),
                        rs.getString("Materia"),
                        rs.getString("Nome"),
                        null, null, null, null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean inserirAtividade(AtividadeProfessorModel atividade) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO atividades (IdMateria, Materia, Professor, NomeAtividade, Atividade, DataEntrega, Nota) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atividade.getIdMateria());
            stmt.setString(2, atividade.getMateria());
            stmt.setString(3, atividade.getProfessor());
            stmt.setString(4, atividade.getNomeAtividade());
            stmt.setString(5, atividade.getPergunta());
            stmt.setString(6, atividade.getDataEntrega());
            stmt.setString(7, atividade.getNota());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
