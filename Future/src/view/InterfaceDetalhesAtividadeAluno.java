package view;

import controller.AtividadesAlunoController;

import javax.swing.*;
import java.awt.*;

public class InterfaceDetalhesAtividadeAluno {
    private JFrame frame;

    public InterfaceDetalhesAtividadeAluno(String nomeUsuario, String nomeAtividade, AtividadesAlunoController controller) {
        frame = new JFrame("Detalhes da Atividade");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        // Preencher os detalhes da atividade
        controller.detalharAtividade(nomeUsuario, nomeAtividade, contentPanel);

        // Adicionar o campo para o aluno inserir sua resposta
        JLabel respostaLabel = new JLabel("Sua Resposta:");
        JTextArea respostaArea = new JTextArea(5, 30);
        JScrollPane respostaScroll = new JScrollPane(respostaArea);

        contentPanel.add(respostaLabel);
        contentPanel.add(respostaScroll);

        // Adicionar o botão para enviar a resposta
        JButton salvarButton = new JButton("Enviar Resposta");
        salvarButton.addActionListener(e -> {
            String respostaAluno = respostaArea.getText();
            if (!respostaAluno.isEmpty()) {
                controller.salvarRespostaAluno(nomeUsuario, nomeAtividade, respostaAluno);
                JOptionPane.showMessageDialog(null, "Resposta enviada com sucesso!");
                respostaArea.setEditable(false); // Desabilita a edição após o envio
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, insira sua resposta.");
            }
        });
        contentPanel.add(salvarButton);

        // Adicionar o conteúdo no JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
