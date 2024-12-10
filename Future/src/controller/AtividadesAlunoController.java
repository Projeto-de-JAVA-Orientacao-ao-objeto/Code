package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.*;
import service.AtividadesAlunoService;

public class AtividadesAlunoController {
    private AtividadesAlunoService service;

    public AtividadesAlunoController() {
        this.service = new AtividadesAlunoService();
    }

    public void listarAtividades(String nomeUsuario, JPanel listaPanel) {
        service.preencherListaAtividades(nomeUsuario, listaPanel);
    }

    public void detalharAtividade(String nomeUsuario, String nomeAtividade, JPanel contentPanel) {
        service.preencherDetalhesAtividade(nomeUsuario, nomeAtividade, contentPanel);
    }

    public void salvarRespostaAluno(String nomeUsuario, String nomeAtividade, String respostaAluno) {
        service.salvarRespostaAluno(nomeUsuario, nomeAtividade, respostaAluno);
    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
