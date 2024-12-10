package factory;

import javax.swing.JFrame;
import view.InterfaceInicialAdministrador;
import view.InterfaceInicialAluno;
import view.InterfaceInicialProfessor;

public class InterfaceLoginFactory {
    
    public static JFrame createInterface(String role, String username) {
        switch (role.toLowerCase()) {
            case "aluno":
                return new InterfaceInicialAluno(username);
            case "professor":
                return new InterfaceInicialProfessor(username);
            case "administrador":
                return new InterfaceInicialAdministrador(username);
            default:
                throw new IllegalArgumentException("Papel de usuário inválido: " + role);
        }
    }
}
