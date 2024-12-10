package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.SaladeaulaAlunoModel;

public class SaladeaulaAlunoDatabase {
    public List<SaladeaulaAlunoModel> carregarMembros(String nomeUsuario) {
        List<SaladeaulaAlunoModel> membrosList = new ArrayList<>();
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sqlMateria = "SELECT IdMateria FROM usuarios WHERE usuario = ?";
            try (PreparedStatement stmtMateria = connection.prepareStatement(sqlMateria)) {
                stmtMateria.setString(1, nomeUsuario);
                ResultSet rsMateria = stmtMateria.executeQuery();

                if (rsMateria.next()) {
                    String idMateria = rsMateria.getString("IdMateria");

                    String sqlAlunos = "SELECT IdUsuario, Nome, Identificacao, Curso, Email FROM usuarios WHERE IdMateria = ?";
                    try (PreparedStatement stmtAlunos = connection.prepareStatement(sqlAlunos)) {
                        stmtAlunos.setString(1, idMateria);
                        ResultSet rsAlunos = stmtAlunos.executeQuery();

                        while (rsAlunos.next()) {
                            SaladeaulaAlunoModel membro = new SaladeaulaAlunoModel();
                            membro.setIdUsuario(rsAlunos.getInt("IdUsuario"));
                            membro.setNome(rsAlunos.getString("Nome"));
                            membro.setIdentificacao(rsAlunos.getString("Identificacao"));
                            membro.setCurso(rsAlunos.getString("Curso"));
                            membro.setEmail(rsAlunos.getString("Email"));
                            membrosList.add(membro);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + e.getMessage());
        }
        return membrosList;
    }
}
