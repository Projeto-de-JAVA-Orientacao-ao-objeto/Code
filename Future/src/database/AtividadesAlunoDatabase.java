package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AtividadesAlunoDatabase {
    public List<String> obterAtividadesPorUsuario(String nomeUsuario) {
        List<String> atividades = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = """
                SELECT a.NomeAtividade
                FROM atividades a
                JOIN usuarios u ON a.IdMateria = u.IdMateria
                WHERE u.usuario = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                atividades.add(rs.getString("NomeAtividade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atividades;
    }

    public List<String> obterDetalhesAtividade(String nomeUsuario, String nomeAtividade) {
        List<String> detalhes = new ArrayList<>();
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT * FROM atividades WHERE NomeAtividade = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeAtividade);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                detalhes.add("Matéria: " + rs.getString("Materia"));
                detalhes.add("Professor: " + rs.getString("Professor"));
                detalhes.add("Descrição: " + rs.getString("Atividade"));
                detalhes.add("Data de Entrega: " + rs.getString("DataEntrega"));
                detalhes.add("Nota: " + rs.getString("Nota"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalhes;
    }

    public String obterStatusEntrega(String nomeUsuario, String nomeAtividade) {
        String status = null;
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = """
                SELECT Entregue FROM atividadesEntregues as a
                left join usuarios as b on a.IdUsuario and b.IdUsuario
                WHERE NomeAtividade = ? AND b.usuario = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeAtividade);
            stmt.setString(2, nomeUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                status = rs.getString("Entregue");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public String obterDataEntrega(String nomeAtividade) {
        String dataEntrega = null;
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT DataEntrega FROM atividades WHERE NomeAtividade = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeAtividade);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dataEntrega = rs.getString("DataEntrega");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataEntrega;
    }

    public void salvarRespostaAluno(String nomeUsuario, String nomeAtividade, String respostaAluno) {
       try (Connection connection = ConexaoBanco.getConnection()) {
            // Primeiro, buscar as informações adicionais necessárias
            String sqlDetalhes = "SELECT a.IdMateria, a.Materia, a.Professor, a.Atividade, a.DataEntrega, a.Nota, u.IdUsuario, u.Nome " +
                                 "FROM atividades a " +
                                 "JOIN usuarios u ON a.IdMateria = u.IdMateria " +
                                 "WHERE a.NomeAtividade = ? AND u.usuario = ?";
            PreparedStatement stmtDetalhes = connection.prepareStatement(sqlDetalhes);
            stmtDetalhes.setString(1, nomeAtividade);
            stmtDetalhes.setString(2, nomeUsuario);
            ResultSet rsDetalhes = stmtDetalhes.executeQuery();
    
            if (rsDetalhes.next()) {
                // Dados para o insert
                String idMateria = rsDetalhes.getString("IdMateria");
                String materia = rsDetalhes.getString("Materia");
                String professor = rsDetalhes.getString("Professor");
                String atividade = rsDetalhes.getString("Atividade");
                String dataEntrega = rsDetalhes.getString("DataEntrega");
                String nota = rsDetalhes.getString("Nota");
                String idUsuario = rsDetalhes.getString("IdUsuario");
                String nomeAluno = rsDetalhes.getString("Nome");
    
                // Inserir os dados na tabela atividadesEntregues
                String sqlInsert = "INSERT INTO atividadesEntregues (IdMateria, Materia, Professor, NomeAtividade, Atividade, DataEntrega, RespostaAluno, Nota, IdUsuario, NomeAluno,Entregue) " +
                                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,'Entregue')";
                PreparedStatement stmtInsert = connection.prepareStatement(sqlInsert);
                stmtInsert.setString(1, idMateria);
                stmtInsert.setString(2, materia);
                stmtInsert.setString(3, professor);
                stmtInsert.setString(4, nomeAtividade);
                stmtInsert.setString(5, atividade);
                stmtInsert.setString(6, dataEntrega);
                stmtInsert.setString(7, respostaAluno);
                stmtInsert.setString(8, nota);
                stmtInsert.setString(9, idUsuario);
                stmtInsert.setString(10, nomeAluno);
                stmtInsert.executeUpdate();
    
                JOptionPane.showMessageDialog(null, "Resposta enviada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao recuperar informações da atividade.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
