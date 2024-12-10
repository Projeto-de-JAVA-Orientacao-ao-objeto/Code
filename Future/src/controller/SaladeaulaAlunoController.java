package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.table.DefaultTableModel;
import service.SaladeaulaAlunoService;

public class SaladeaulaAlunoController {
    private SaladeaulaAlunoService saladeaulaAlunoService;

    public SaladeaulaAlunoController() {
        this.saladeaulaAlunoService = new SaladeaulaAlunoService();
    }


    public void listarMembros(DefaultTableModel model, String nomeUsuario) {

        saladeaulaAlunoService.carregarMembros(nomeUsuario, model);

    }

    public void voltarParaTelaInicial(String nomeUsuario) {
        // Redireciona para a interface inicial do aluno
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
