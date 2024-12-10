package service;

import model.UsuarioModel;
import java.sql.*;
import database.ConexaoBanco;

public class AutenticacaoService {
    public String authenticate(UsuarioModel user) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT identificacao FROM usuarios WHERE usuario = ? AND senha = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("identificacao");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

