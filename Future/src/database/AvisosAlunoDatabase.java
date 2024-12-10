package database;

import model.AvisosAlunoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvisosAlunoDatabase {
    public List<AvisosAlunoModel> obterAvisosPorUsuario(String nomeUsuario) {
        List<AvisosAlunoModel> avisos = new ArrayList<>();
        String sql = """
            SELECT a.Titulo, a.Aviso
            FROM avisos a
            INNER JOIN usuarios u ON a.IdMateria = u.IdMateria
            WHERE u.Usuario = ?
        """;

        try (Connection connection = ConexaoBanco.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AvisosAlunoModel aviso = new AvisosAlunoModel();
                aviso.setTitulo(rs.getString("Titulo"));
                aviso.setAviso(rs.getString("Aviso"));
                avisos.add(aviso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avisos;
    }

    public String obterDetalhesAviso(String tituloAviso) {
        String sql = "SELECT a.Aviso FROM avisos a WHERE a.Titulo = ?";
        try (Connection connection = ConexaoBanco.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tituloAviso);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("Aviso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Detalhes não encontrados para este aviso.";
    }
}
