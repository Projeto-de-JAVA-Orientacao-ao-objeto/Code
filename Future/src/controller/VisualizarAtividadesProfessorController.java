package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.VisualizarAtividadesProfessorService;

public class VisualizarAtividadesProfessorController {
    private VisualizarAtividadesProfessorService service;

    public VisualizarAtividadesProfessorController() {
        service = new VisualizarAtividadesProfessorService();
    }

    public void carregarAtividades(DefaultTableModel tableModel) {
        service.preencherTabelaAtividades(tableModel);
    }

    public void voltarParaTelaInicial(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
