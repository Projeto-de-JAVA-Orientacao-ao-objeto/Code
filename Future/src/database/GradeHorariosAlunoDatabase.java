package database;

import model.GradeHorariosAlunoModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeHorariosAlunoDatabase {
    public List<GradeHorariosAlunoModel> obterGradeHorarios(String usuario) {
        List<GradeHorariosAlunoModel> horarios = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT b.dia, b.materia, b.horarioinicio, b.horariofim " +
                         "FROM usuarios AS a " +
                         "LEFT JOIN aulas AS b ON a.IdMateria = b.IdMateria " +
                         "WHERE a.usuario = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, usuario);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        GradeHorariosAlunoModel horario = new GradeHorariosAlunoModel();
                        horario.setDia(rs.getString("dia"));
                        horario.setMateria(rs.getString("materia"));
                        horario.setHorarioInicio(rs.getString("horarioinicio"));
                        horario.setHorarioFim(rs.getString("horariofim"));
                        horarios.add(horario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horarios;
    }
}
