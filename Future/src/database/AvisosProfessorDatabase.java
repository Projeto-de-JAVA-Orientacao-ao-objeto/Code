package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvisosProfessorDatabase {
    public String[] buscarDadosProfessor(String nomeUsuario) {
        String[] professorData = null;

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT IdMateria, Materia, Nome FROM usuarios WHERE usuario = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                professorData = new String[3];
                professorData[0] = rs.getString("IdMateria");
                professorData[1] = rs.getString("Materia");
                professorData[2] = rs.getString("Nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professorData;
    }

    public boolean inserirAviso(String idMateria, String materia, String professor, String titulo, String aviso) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "INSERT INTO avisos (IdMateria, Materia, Professor, Titulo, Aviso) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, idMateria);
            stmt.setString(2, materia);
            stmt.setString(3, professor);
            stmt.setString(4, titulo);
            stmt.setString(5, aviso);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
