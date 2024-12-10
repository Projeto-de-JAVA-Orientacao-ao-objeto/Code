package service;

import controller.AtividadesAlunoController;
import database.AtividadesAlunoDatabase;
import java.awt.*;
import javax.swing.*;
import strategy.ValidacaoDataEntregaAluno;
import strategy.ValidacaoEntregueAluno;
import strategy.ValidadorAtividadeAluno;
import view.BordaRedonda;
import view.BotaoArredondado;

public class AtividadesAlunoService {
    private AtividadesAlunoDatabase database;

    public AtividadesAlunoService() {
        this.database = new AtividadesAlunoDatabase();
    }

    // Modificado: Alterando o layout do painel externo e interno, e adicionando o botão Visualizar
    public void preencherListaAtividades(String nomeUsuario, JPanel listaPanel) {
        var atividades = database.obterAtividadesPorUsuario(nomeUsuario);
    
        // Painel externo para o quadro geral
        //JPanel painelExterno = new JPanel();
        //painelExterno.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Layout para empilhar os cards
        //painelExterno.setBackground(new Color(230, 230, 230)); // Cinza
        //painelExterno.setPreferredSize(new Dimension(1227, 783));
    
        for (String atividade : atividades) {
            // Painel interno para cada atividade (branco)
            //JPanel cardPanel = new JPanel();
            BordaRedonda cardPanel = new BordaRedonda(15);
            cardPanel.setLayout(null); // Layout absoluto para controle manual
            cardPanel.setBackground(Color.WHITE);
            
            cardPanel.setPreferredSize(new Dimension(1060, 120));
    
            // Componentes do card
            JLabel nomeAtividadeLabel = new JLabel("<html><b>" + atividade + "</b></html>");
            nomeAtividadeLabel.setBounds(20, 10, 600, 30);
            nomeAtividadeLabel.setFont(new Font("Arial", Font.BOLD, 18));
    
            JLabel professorLabel = new JLabel("Professor: Nome do Professor");
            professorLabel.setBounds(20, 40, 300, 20);
            professorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    
            // Botão Visualizar
            //JButton visualizarButton = new JButton("Visualizar");
            BotaoArredondado visualizarButton = new BotaoArredondado("Visualizar",15);
            visualizarButton.setBounds(900, 30, 120, 40);
            visualizarButton.setBackground(new Color(33, 150, 243)); // Azul
            visualizarButton.setForeground(Color.WHITE);
            visualizarButton.setFont(new Font("Cabin", Font.BOLD, 14));
            visualizarButton.addActionListener(e -> {
                ValidadorAtividadeAluno validador = new ValidadorAtividadeAluno();
                validador.adicionarValidacao(new ValidacaoEntregueAluno(database));
                validador.adicionarValidacao(new ValidacaoDataEntregaAluno(database));
            
                boolean podeResponder = validador.validar(nomeUsuario, atividade);
            
                if (podeResponder) {
                    new view.InterfaceDetalhesAtividadeAluno(nomeUsuario, atividade, new AtividadesAlunoController());
                } else {
                    JOptionPane.showMessageDialog(null, "Você não pode responder a esta atividade.");
                }
            });

            
    
            // Adiciona os componentes ao painel interno
            cardPanel.add(nomeAtividadeLabel);
            cardPanel.add(professorLabel);
            cardPanel.add(visualizarButton);
    
            // Adiciona o card ao painel externo
            listaPanel.add(cardPanel);
            listaPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre os cards
        }
    
        // Adiciona o painel geral com todos os cards
        //listaPanel.add(painelExterno); 
        //listaPanel.revalidate();
        //listaPanel.repaint();
    }
    
    

    // Modificado: Método para preencher os detalhes da atividade
    public void preencherDetalhesAtividade(String nomeUsuario, String nomeAtividade, JPanel contentPanel) {
        var detalhes = database.obterDetalhesAtividade(nomeUsuario, nomeAtividade);

        for (var detalhe : detalhes) {
            JLabel label = new JLabel(detalhe);
            contentPanel.add(label);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void salvarRespostaAluno(String nomeUsuario, String nomeAtividade, String respostaAluno) {
        database.salvarRespostaAluno(nomeUsuario, nomeAtividade, respostaAluno);
    }
}
