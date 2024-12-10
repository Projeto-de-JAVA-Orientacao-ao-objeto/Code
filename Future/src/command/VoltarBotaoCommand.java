package command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.ConexaoBanco;


public class VoltarBotaoCommand implements Command {
    private String nomeUsuario;



    public VoltarBotaoCommand(String nomeUsuario) {

        this.nomeUsuario = nomeUsuario;

    }

    public void execute() {

        String identificacao = obterIdentificacaoUsuario(nomeUsuario);
        
        if (identificacao.equalsIgnoreCase("administrador")) {
            new view.InterfaceInicialAdministrador(nomeUsuario).setVisible(true);
        } else if (identificacao.equalsIgnoreCase("aluno")) {
            new view.InterfaceInicialAluno(nomeUsuario).setVisible(true);
        } else if (identificacao.equalsIgnoreCase("professor")) {
            new view.InterfaceInicialProfessor(nomeUsuario).setVisible(true);
        } else {
            // Caso a identificação não seja reconhecida
            JOptionPane.showMessageDialog(null, "Usuário não identificado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obterIdentificacaoUsuario(String nomeUsuario) {
        try (Connection connection = ConexaoBanco.getConnection()) {
            String sql = "SELECT identificacao FROM usuarios WHERE usuario = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, nomeUsuario);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("identificacao");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar os dados do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
        
    }
}
