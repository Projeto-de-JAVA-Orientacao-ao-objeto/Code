package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.MembrosMateriaProfessorService;

public class MembrosMateriaProfessorController {
    private MembrosMateriaProfessorService membrosMateriaProfessorService;

    public MembrosMateriaProfessorController() {
        this.membrosMateriaProfessorService = new MembrosMateriaProfessorService();
    }

    public void listarMembros(DefaultTableModel model, String nomeUsuario) {

        membrosMateriaProfessorService.carregarMembros(nomeUsuario, model);


    }

    public void voltar(String nomeUsuario) {
        // Redireciona para a tela inicial do professor
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
