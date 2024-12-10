package view;

import controller.AssistirAulaProfessorController;
import java.awt.*;
import javax.swing.*;

public class InterfaceAssistirAulaProfessor extends JFrame {

    private AssistirAulaProfessorController controller;

    public InterfaceAssistirAulaProfessor(String nomeUsuario, AssistirAulaProfessorController controller) {
        this.controller = controller;


        setTitle("Aula - Link:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

        setupHeader(nomeUsuario);
        setupContent(nomeUsuario);

        setVisible(true);
    }

    private void setupHeader(String nomeUsuario) {
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cria o gradiente
                Graphics2D g2d = (Graphics2D) g;
                // Gradiente com mais azul no começo e a transição para o cinza mais à direita
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 51, 102), getWidth() + 200 , 0, new Color(112, 128, 144)); // Azul para cinza claro
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight()); // Preenche o painel com o gradiente
            }
        };

        headerPanel.setBounds(0, 0, 1440, 70); // Definindo o tamanho do painel de gradiente
        headerPanel.setLayout(null);

        // Logo à direita na faixa azul
        ImageIcon logoIcon = new ImageIcon("Logo/Logo.png"); // Caminho simplificado
        Image logoImage = logoIcon.getImage();  // Converte para imagem
        Image scaledLogo = logoImage.getScaledInstance(320, 60, Image.SCALE_SMOOTH); // Aumenta o tamanho da logo
        logoIcon = new ImageIcon(scaledLogo); // Cria o novo ImageIcon com a imagem redimensionada

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(1000, 5, 320, 60); // Ajuste da posição e tamanho da logo
        headerPanel.add(logoLabel); // Adiciona à parte azul da faixa

        JLabel messageLabel = new JLabel("Quadro de aulas", JLabel.CENTER);
        messageLabel.setBounds(0, 80, 1440, 40);
        messageLabel.setFont(new Font("Cabin", Font.BOLD, 40));
        messageLabel.setForeground(Color.black);
        add(messageLabel);

        JPanel linhaSeparadora = new JPanel();
        linhaSeparadora.setBounds(0, 130, 1440, 2); // Largura total da interface e altura de 2px
        linhaSeparadora.setBackground(Color.GRAY); // Define a cor cinza para a linha
        add(linhaSeparadora); // Adiciona o painel da linha ao JFrame

        // Botão "Voltar"
        BotaoArredondado voltarButton = new BotaoArredondado("Voltar",15);
        voltarButton.setBounds(20, 20, 100, 30);

        // Define a cor de fundo com um vermelho mais suave
        voltarButton.setBackground(new Color(211, 47, 47)); // Vermelho suave (RGB: 211, 47, 47)

        // Define a cor do texto do botão como branco
        voltarButton.setForeground(Color.WHITE);

        // Define a fonte do botão
        voltarButton.setFont(new Font("Cabin", Font.BOLD, 16));

        voltarButton.addActionListener(e -> {
            dispose();
            controller.voltar(nomeUsuario);
        });

        headerPanel.add(logoLabel);
        headerPanel.add(voltarButton);
        add(headerPanel);
    }

    private void setupContent(String nomeUsuario) {
        String[][] aulaData = controller.obterDadosAulas(nomeUsuario);
    
        // Exibe os quadrados representando os dias da semana
        String[] diasSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        int xPosition = 25;
    
        for (int i = 0; i < 5; i++) {
            // Configuração do painel para o dia da semana

            BordaRedonda diaPanel = new BordaRedonda(15);
            diaPanel.setLayout(null); // Layout absoluto
            diaPanel.setBackground(Color.WHITE);
            diaPanel.setBounds(xPosition, 200, 250, 300); // Posição e tamanho
            //diaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
            // Label para o dia da semana
            JLabel diaLabel = new JLabel(diasSemana[i], JLabel.CENTER);
            diaLabel.setFont(new Font("Cabin", Font.BOLD, 22));
            diaLabel.setBounds(10, 10, 230, 30); // Define a posição e tamanho do rótulo do dia
            diaPanel.add(diaLabel);
    
            // Adiciona as informações da aula no dia correspondente
            if (aulaData != null && aulaData[i] != null) {
                // Exibe as informações da aula
                String infoAula = "<html><b>Matéria:</b> " + aulaData[i][0] + "<br><b>Início:</b> " + aulaData[i][1] +
                                  "<br><b>Fim:</b> " + aulaData[i][2] + "</html>";
                JLabel aulaLabel = new JLabel(infoAula, JLabel.LEFT);
                aulaLabel.setFont(new Font("Cabin", Font.BOLD, 16));
                aulaLabel.setForeground(Color.BLACK);
                aulaLabel.setBounds(10, 50, 230, 80); // Define a posição e tamanho do rótulo da aula
                diaPanel.add(aulaLabel);
            
                // Botão para acessar a aula

                BotaoArredondado acessarButton = new BotaoArredondado("Acessar Aula",15);

                acessarButton.setBackground(new Color(33, 150, 243)); // Azul
                acessarButton.setForeground(Color.WHITE);

                //JButton acessarButton = new JButton("Acessar Aula");
                acessarButton.setFont(new Font("Cabin", Font.BOLD, 14));
                acessarButton.setBounds(40, 170, 170, 30); // Define a posição e tamanho do botão
                acessarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
                // Verifica se o link não é nulo antes de adicionar a ação
                if (aulaData[i][3] != null) {
                    String link = aulaData[i][3]; // Necessário para uso em expressão lambda
                    acessarButton.addMouseListener(controller.abrirLink(link)); 
                    System.out.println("Link para acessar: " + link);
                } else {
                    acessarButton.setEnabled(false); // Desativa o botão se não houver link
                }
            
                diaPanel.add(acessarButton);
            } else {
                // Label para "Sem aula"
                JLabel noClassLabel = new JLabel("<html><i>Sem aula</i></html>", JLabel.CENTER);
                noClassLabel.setFont(new Font("Cabin", Font.ITALIC, 14));
                noClassLabel.setBounds(10, 50, 230, 30); // Define a posição e tamanho do rótulo "Sem aula"
                diaPanel.add(noClassLabel);
            }
            
    
            // Adiciona o painel de dia ao painel principal
            add(diaPanel);
            xPosition += 260; // Espaçamento entre os quadrados
        }
    
        // Atualiza a interface
        revalidate();
        repaint();
    }
    
}
