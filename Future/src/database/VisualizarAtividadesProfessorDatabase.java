package database;

import model.VisualizarAtividadesProfessorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisualizarAtividadesProfessorDatabase {
    public List<VisualizarAtividadesProfessorModel> obterAtividades() {
        List<VisualizarAtividadesProfessorModel> atividades = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = """
                SELECT IdMateria, Materia, NomeAtividade, Atividade, DataEntrega, Nota
                FROM atividades
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VisualizarAtividadesProfessorModel atividade = new VisualizarAtividadesProfessorModel();
                atividade.setIdMateria(rs.getInt("IdMateria"));
                atividade.setMateria(rs.getString("Materia"));
                atividade.setNomeAtividade(rs.getString("NomeAtividade"));
                atividade.setPergunta(rs.getString("Atividade"));
                atividade.setDataEntrega(rs.getString("DataEntrega"));
                atividade.setNota(rs.getDouble("Nota"));

                atividades.add(atividade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atividades;
    }
}
