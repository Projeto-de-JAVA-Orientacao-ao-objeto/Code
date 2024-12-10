package controller;

import command.Command;
import command.VoltarBotaoCommand;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import service.AvisosAlunoService;

public class AvisosAlunoController {
    private AvisosAlunoService avisosAlunoService;

    public AvisosAlunoController() {
        this.avisosAlunoService = new AvisosAlunoService();
    }

    public void carregarAvisos(String nomeUsuario, DefaultTableModel model, JTable tabela) {
        avisosAlunoService.preencherTabelaAvisos(nomeUsuario, model);

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    String tituloAviso = (String) tabela.getValueAt(row, 0);
                    String detalhes = avisosAlunoService.obterDetalhesAviso(tituloAviso);
                    JOptionPane.showMessageDialog(null, detalhes);
                }
            }
        });
    }

    public void voltar(String nomeUsuario) {
        // Redireciona para a tela inicial do aluno
        Command voltarCommand = new VoltarBotaoCommand(nomeUsuario);
        voltarCommand.execute();
    }
}
