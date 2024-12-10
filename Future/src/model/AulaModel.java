package model;

import database.ConexaoBanco;
import java.sql.*;

public class AulaModel {

    private String nomeMateria;
    private String horarioInicio;
    private String horarioFim;
    private String link;

    // Getters e Setters
    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // Método para buscar dados da aula no banco de dados
    public static AulaModel buscarLinkDaAula(String nomeUsuario) {
        AulaModel aula = null;
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT b.materia, b.horarioinicio, b.horariofim, b.linkSaladeAula " +
                         "FROM usuarios AS a " +
                         "LEFT JOIN aulas AS b ON a.IdMateria = b.IdMateria " +
                         "WHERE a.usuario = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                aula = new AulaModel();
                aula.setNomeMateria(rs.getString("materia"));
                aula.setHorarioInicio(rs.getString("horarioinicio"));
                aula.setHorarioFim(rs.getString("horariofim"));
                aula.setLink(rs.getString("linkSaladeAula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aula;
    }
}