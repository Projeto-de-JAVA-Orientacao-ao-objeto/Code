package database;

import model.ListarAulasModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListarAulasDatabase {
    public List<ListarAulasModel> obterTodasAulas() {
        List<ListarAulasModel> aulas = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT IdMateria, Materia, Horarioinicio, Horariofim, dia, periodo, linkSaladeAula FROM aulas";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    ListarAulasModel aula = new ListarAulasModel();
                    aula.setIdMateria(rs.getString("IdMateria"));
                    aula.setMateria(rs.getString("Materia"));
                    aula.setHorarioInicio(rs.getString("Horarioinicio"));
                    aula.setHorarioFim(rs.getString("Horariofim"));
                    aula.setDia(rs.getString("dia"));
                    aula.setPeriodo(rs.getString("periodo"));
                    aula.setLinkSala(rs.getString("linkSaladeAula"));

                    aulas.add(aula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aulas;
    }
}
