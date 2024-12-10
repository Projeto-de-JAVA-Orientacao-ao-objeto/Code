package controller;

import command.Command;
import command.VoltarBotaoCommand;
import model.AvisosProfessorModel;
import service.AvisosProfessorService;

public class AvisosProfessorController {
    private AvisosProfessorService service;

    public AvisosProfessorController() {
        this.service = new AvisosProfessorService();
    }

    public AvisosProfessorModel buscarDadosProfessor(String nomeUsuario) {
        return service.buscarDadosProfessor(nomeUsuario);
    }

    public boolean inserirAviso(AvisosProfessorModel aviso, String titulo, String mensagem) {
        return service.inserirAviso(aviso, titulo, mensagem);
    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
