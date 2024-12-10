package controller;

import command.Command;
import command.VoltarBotaoCommand;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.event.MouseInputAdapter;
import service.AssistirAulaAlunoService;

public class AssistirAulaAlunoController {
    private AssistirAulaAlunoService service;

    public AssistirAulaAlunoController() {
        this.service = new AssistirAulaAlunoService();
    }

    public String[][] obterDadosAulas(String nomeUsuario) {
        return service.buscarDadosAulas(nomeUsuario);
    }

    public void voltar(String nomeUsuario) {
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }

    public MouseInputAdapter abrirLink(String link) {
        return new MouseInputAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (link != null && !link.isEmpty()) {
                    try {
                        Desktop.getDesktop().browse(new URI(link));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("O link não está disponível.");
                }
            }
        };
    }
}
