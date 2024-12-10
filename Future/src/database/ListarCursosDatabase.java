package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ListarCursosModel;

public class ListarCursosDatabase {
    public List<ListarCursosModel> obterTodosCursos() {
        List<ListarCursosModel> cursos = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT IdCurso, IdMateria, Curso, Materia, Modulo FROM cursos";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    ListarCursosModel curso = new ListarCursosModel();
                    curso.setIdCurso(rs.getString("IdCurso"));
                    curso.setIdMateria(rs.getString("IdMateria"));
                    curso.setCurso(rs.getString("Curso"));
                    curso.setMateria(rs.getString("Materia"));
                    curso.setModulo(rs.getString("Modulo"));

                    cursos.add(curso);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }
}
