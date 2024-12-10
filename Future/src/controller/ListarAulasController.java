package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.ListarAulasService;

public class ListarAulasController {
    private ListarAulasService listarAulasService;

    public ListarAulasController() {
        this.listarAulasService = new ListarAulasService();
    }

    public void listarAulas(DefaultTableModel model) {
        listarAulasService.preencherTabelaAulas(model);
    }

    public void voltar(String nomeUsuario) {
        // Redireciona para a tela inicial do administrador
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
