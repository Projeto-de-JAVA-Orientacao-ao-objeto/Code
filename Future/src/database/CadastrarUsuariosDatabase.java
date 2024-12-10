package database;

import java.sql.*;
import model.CadastrarUsuariosModel;

public class CadastrarUsuariosDatabase {

    public void inserirUsuario(CadastrarUsuariosModel usuarios) {
        String url = "jdbc:mysql://localhost:3306/future";
        String usuarioBD = "root";
        String senhaBD = "future2024";

        try (Connection conn = DriverManager.getConnection(url, usuarioBD, senhaBD)) {
            String sql = "INSERT INTO usuarios (idUsuario, nome, usuario, senha, identificacao, email, telefone,IdCurso,Curso,IdMateria,Materia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, usuarios.getIdUsuario());
                stmt.setString(2, usuarios.getNome());
                stmt.setString(3, usuarios.getUsuario());
                stmt.setString(4, usuarios.getSenha());
                stmt.setString(5, usuarios.getIdentificacao());
                stmt.setString(6, usuarios.getEmail());
                stmt.setString(7, usuarios.getTelefone());
                stmt.setString(8, usuarios.getIdCurso());
                stmt.setString(9, usuarios.getCurso());
                stmt.setString(10, usuarios.getIdMateria());
                stmt.setString(11, usuarios.getMateria());

                stmt.executeUpdate();
                System.out.println("Usuário cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
