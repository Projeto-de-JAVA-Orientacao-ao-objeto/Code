package controller;

import command.Command;
import command.VoltarBotaoCommand;
import model.AtividadeProfessorModel;
import service.AtividadeProfessorService;

public class AtividadeProfessorController {
    private AtividadeProfessorService service;

    public AtividadeProfessorController() {
        this.service = new AtividadeProfessorService();
    }

    public AtividadeProfessorModel buscarDadosProfessor(String nomeUsuario) {
        return service.obterDadosProfessor(nomeUsuario);
    }

    public boolean salvarAtividade(AtividadeProfessorModel atividade) {
        return service.inserirAtividade(atividade);
    }

    public void voltarParaTelaInicial(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
