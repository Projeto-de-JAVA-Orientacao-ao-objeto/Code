package database;

import model.VisualizarNotasAlunoModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisualizarNotasAlunoDatabase {

    public void carregarNotasAluno(String nomeUsuario, DefaultTableModel model) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = """
                SELECT a.NomeAtividade, a.Nota AS NotaMaxima, ae.NotaAluno
                FROM atividades a
                INNER JOIN atividadesEntregues ae ON a.NomeAtividade = ae.NomeAtividade
                INNER JOIN usuarios u ON ae.NomeAluno = u.Nome
                WHERE u.Usuario = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nomeAtividade = rs.getString("NomeAtividade");
                double notaMaxima = rs.getDouble("NotaMaxima");
                double notaAluno = rs.getDouble("NotaAluno");
                double porcentagem = (notaAluno / notaMaxima) * 100;

                model.addRow(new Object[]{
                    nomeAtividade,
                    notaMaxima,
                    notaAluno,
                    String.format("%.2f", porcentagem)
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
