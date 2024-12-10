package controller;

import command.Command;
import command.VoltarBotaoCommand;
import model.CadastrarAulasModel;
import service.CadastrarAulasService;
import singleton.AulaCadastroSingleton;

public class CadastrarAulasController {
    private CadastrarAulasService cadastrarAulasService;

    public CadastrarAulasController() {
        this.cadastrarAulasService = new CadastrarAulasService();
    }

    public void cadastrarAula(String idMateria, String materia, String horarioInicio, String horarioFim, String dia, String periodo, String linkSaladeAula) {
        CadastrarAulasModel aula = new CadastrarAulasModel(idMateria, materia, horarioInicio, horarioFim, dia, periodo, linkSaladeAula);

        // Usando o Singleton para gerenciar o cadastro de aulas
        AulaCadastroSingleton.getInstance().cadastrarAula(aula);
    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
