package database;

import java.sql.*;
import model.CadastrarAulasModel;

public class CadastrarAulasDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/future";
    private static final String USER = "root";
    private static final String PASSWORD = "future2024";

    public void inserirAula(CadastrarAulasModel aula) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO aulas (IdMateria, Materia, horarioInicio, horarioFim, dia, periodo, linkSaladeAula) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, aula.getIdMateria());
                stmt.setString(2, aula.getMateria());
                stmt.setString(3, aula.getHorarioInicio());
                stmt.setString(4, aula.getHorarioFim());
                stmt.setString(5, aula.getDia());
                stmt.setString(6, aula.getPeriodo());
                stmt.setString(7, aula.getlinkSaladeAula());

                stmt.executeUpdate();
                System.out.println("Aula cadastrada com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
