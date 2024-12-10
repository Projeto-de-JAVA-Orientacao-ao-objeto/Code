package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.DistribuirNotasProfessorService;

public class DistribuirNotasProfessorController {
    private DistribuirNotasProfessorService service;

    public DistribuirNotasProfessorController() {
        this.service = new DistribuirNotasProfessorService();
    }

    public void carregarAtividades(String nomeUsuario, DefaultTableModel tableModel) {
        service.carregarAtividades(nomeUsuario, tableModel);
    }

    public void mostrarAlunos(String nomeUsuario, String nomeAtividade, DefaultTableModel tableModel) {
        service.mostrarAlunos(nomeUsuario, nomeAtividade, tableModel);
    }

    public void atribuirNota(String nomeUsuario, String nomeAtividade, String nomeAluno, double nota) {
        service.atribuirNota(nomeUsuario, nomeAtividade, nomeAluno, nota);
    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
