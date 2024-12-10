package factory;

import controller.*;
import javax.swing.JFrame;
import model.UsuarioModel;
import view.*;

public class InterfaceProfessorFactory {


    // Método Factory para criar as interfaces
    public static JFrame criarTela(String tipo, UsuarioModel usuario) {
        switch (tipo) {
            case "AssistirAula":
                return new InterfaceAssistirAulaProfessor(usuario.getUsername(), new AssistirAulaProfessorController());
            case "AtividadesProfessor":
                return new InterfaceAtividadeProfessor(usuario.getUsername(), new AtividadeProfessorController());
            case "DistribuirNotas":
                return new InterfaceDistribuirNotasProfessor(usuario.getUsername(), new DistribuirNotasProfessorController());
            case "MembrosMateria":
                return new InterfaceMembrosMateriaProfessor(usuario.getUsername(), new MembrosMateriaProfessorController());
            case "VisualizarAtividades":
                return new InterfaceVisualizarAtividadesProfessor(usuario.getUsername(), new VisualizarAtividadesProfessorController());
            case "AvisosProfessor":
                return new InterfaceAvisosProfessor(usuario.getUsername(), new AvisosProfessorController());
            default:
                throw new IllegalArgumentException("Tipo de tela desconhecido");
        }
    }
}


