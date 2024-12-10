package database;

import java.sql.*;
import model.CadastrarCursosModel;

public class CadastrarCursosDatabase {

    public void inserirCurso(CadastrarCursosModel curso) {
        String url = "jdbc:mysql://localhost:3306/future";
        String usuarioBD = "root";
        String senhaBD = "future2024";

        try (Connection conn = DriverManager.getConnection(url, usuarioBD, senhaBD)) {
            String sql = "INSERT INTO cursos (idCurso, idMateria, curso, materia, modulo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, curso.getIdCurso());
                stmt.setString(2, curso.getIdMateria());
                stmt.setString(3, curso.getCurso());
                stmt.setString(4, curso.getMateria());
                stmt.setString(5, curso.getModulo());


                stmt.executeUpdate();
                System.out.println("Curso cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
