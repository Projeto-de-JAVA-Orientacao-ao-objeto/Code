package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.ListarUsuariosService;

public class ListarUsuariosController {
    private ListarUsuariosService listarUsuariosService;

    public ListarUsuariosController() {
        this.listarUsuariosService = new ListarUsuariosService();
    }

    public void listarUsuarios(DefaultTableModel model) {
        listarUsuariosService.preencherTabelaUsuarios(model);
    }

    public void voltar(String nomeUsuario) {
        // Redireciona para a tela inicial do administrador
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
