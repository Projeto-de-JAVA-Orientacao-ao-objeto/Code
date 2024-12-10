package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.ListarCursosService;

public class ListarCursosController {
    private ListarCursosService listarCursosService;

    public ListarCursosController() {
        this.listarCursosService = new ListarCursosService();
    }

    public void listarCursos(DefaultTableModel model) {
        listarCursosService.preencherTabelaCursos(model);
    }

    public void voltar(String nomeUsuario) {
        // Redireciona para a tela inicial do administrador
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
