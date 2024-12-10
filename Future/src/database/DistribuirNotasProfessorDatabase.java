package database;

import model.DistribuirNotasProfessorModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistribuirNotasProfessorDatabase {
    public List<DistribuirNotasProfessorModel> obterAtividades(String nomeUsuario) {
        List<DistribuirNotasProfessorModel> atividades = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = """
                SELECT a.IdMateria, a.Materia, a.NomeAtividade, a.DataEntrega, a.Nota
                FROM atividades a
                INNER JOIN usuarios u ON a.Professor = u.Nome
                WHERE u.Usuario = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DistribuirNotasProfessorModel atividade = new DistribuirNotasProfessorModel();
                atividade.setIdMateria(rs.getString("IdMateria"));
                atividade.setMateria(rs.getString("Materia"));
                atividade.setNomeAtividade(rs.getString("NomeAtividade"));
                atividade.setDataEntrega(rs.getString("DataEntrega"));
                atividade.setNota(rs.getDouble("Nota"));
                atividades.add(atividade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atividades;
    }

    public List<DistribuirNotasProfessorModel> obterAlunosPorAtividade(String nomeUsuario, String nomeAtividade) {
        List<DistribuirNotasProfessorModel> alunos = new ArrayList<>();
        
        try (Connection connection = ConexaoBanco.getConnection()) {
            // Alteração: Consulta SQL agora filtra apenas pelo nomeAtividade
            String sql = """
                SELECT ae.NomeAluno, ae.NotaAluno
                FROM atividadesEntregues ae
                WHERE ae.NomeAtividade = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeAtividade);  // Apenas um parâmetro (NomeAtividade)
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
                DistribuirNotasProfessorModel aluno = new DistribuirNotasProfessorModel();
                aluno.setNomeAtividade(nomeAtividade);  // A atividade do aluno
                aluno.setNomeAluno(rs.getString("NomeAluno"));  // Nome do aluno
                aluno.setNota(rs.getDouble("NotaAluno"));  // Nota do aluno
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return alunos;
    }
    
    

    public void atualizarNota(String nomeUsuario, String nomeAtividade, String nomeAluno, double nota) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = """
                UPDATE atividadesEntregues
                SET NotaAluno = ?
                WHERE NomeAtividade = ? AND NomeAluno = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, nota);
            stmt.setString(2, nomeAtividade);
            stmt.setString(3, nomeAluno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
