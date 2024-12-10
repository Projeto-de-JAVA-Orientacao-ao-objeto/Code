package database;

import model.ListarUsuariosModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListarUsuariosDatabase {
    public List<ListarUsuariosModel> obterTodosUsuarios() {
        List<ListarUsuariosModel> usuarios = new ArrayList<>();

        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT IdUsuario, nome, usuario, senha, identificacao, email, telefone, IdCurso, curso, IdMateria, materia FROM usuarios";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    ListarUsuariosModel usuario = new ListarUsuariosModel();
                    usuario.setIdUsuario(rs.getString("IdUsuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setUsuario(rs.getString("usuario"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setIdentificacao(rs.getString("identificacao"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setIdCurso(rs.getString("IdCurso"));
                    usuario.setCurso(rs.getString("curso"));
                    usuario.setIdMateria(rs.getString("IdMateria"));
                    usuario.setMateria(rs.getString("materia"));

                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}
