package factory;

import controller.*;
import javax.swing.JFrame;
import model.UsuarioModel;
import view.*;

public class InterfaceAlunoFactory {


    // Método Factory para criar as interfaces
    public static JFrame criarTela(String tipo, UsuarioModel usuario) {
        switch (tipo) {
            case "AssistirAula":
                return new InterfaceAssistirAulaAluno(usuario.getUsername(), new AssistirAulaAlunoController());
            case "AtividadesAluno":
                return new InterfaceAtividadesAluno(usuario.getUsername(), new AtividadesAlunoController());
            case "VisualizarNotas":
                return new InterfaceVisualizarNotasAluno(usuario.getUsername(), new VisualizarNotasAlunoController());
            case "SaladeAula":
                return new InterfaceSaladeaulaAluno(usuario.getUsername(), new SaladeaulaAlunoController());
            case "GradeHorarios":
                return new InterfaceGradeHorariosAluno(usuario.getUsername(), new GradeHorariosAlunoController());
            case "AvisosAluno":
                return new InterfaceAvisosAluno(usuario.getUsername(), new AvisosAlunoController());
            default:
                throw new IllegalArgumentException("Tipo de tela desconhecido");
        }
    }
}


