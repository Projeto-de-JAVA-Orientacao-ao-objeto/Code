package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.VisualizarNotasAlunoService;

public class VisualizarNotasAlunoController {
    private VisualizarNotasAlunoService service;

    public VisualizarNotasAlunoController() {
        this.service = new VisualizarNotasAlunoService();
    }

    public void carregarNotas(String nomeUsuario, DefaultTableModel model) {
        service.preencherTabelaNotas(nomeUsuario, model);
    }

    public void voltarParaTelaInicial(String nomeUsuario) {
        // Redireciona para a interface inicial do aluno
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
