package view;

import controller.AtividadesAlunoController;
import java.awt.*;
import javax.swing.*;

public class InterfaceAtividadesAluno extends JFrame {

    private AtividadesAlunoController controller;

    public InterfaceAtividadesAluno(String nomeUsuario, AtividadesAlunoController controller) {
        this.controller = controller;

        setTitle("Quadro de Atividades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);


        setupHeader(nomeUsuario);
        setupAtividadesPanel(nomeUsuario);

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
    
        JLabel tituloLabel = new JLabel("Quadro de Atividades");
        tituloLabel.setFont(new Font("Cabin", Font.BOLD, 42));
        tituloLabel.setForeground(Color.BLACK);
        tituloLabel.setBounds(400, 105, 500, 80); // Centralizado no painel
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
    

        add(tituloLabel);

        BotaoArredondado voltarButton = new BotaoArredondado("Voltar",15);
        voltarButton.setBounds(20, 20, 100, 30);

        // Define a cor de fundo com um vermelho mais suave
        voltarButton.setBackground(new Color(211, 47, 47)); // Vermelho suave (RGB: 211, 47, 47)

        // Define a cor do texto do botão como branco
        voltarButton.setForeground(Color.WHITE);

        // Define a fonte do botão
        voltarButton.setFont(new Font("Cabin", Font.BOLD, 16));
        //voltarButton.setBorder(new BordaRedonda(15));
        voltarButton.addActionListener(e -> {
            dispose();
            controller.voltar(nomeUsuario);
        });
        

        headerPanel.add(voltarButton);
        add(headerPanel);
    }
    

    private void setupAtividadesPanel(String nomeUsuario) {
        
        //JPanel listaPanel = new JPanel();
        BordaRedonda listaPanel = new BordaRedonda(15);
        listaPanel.setBounds(108, 187, 1100, 450);
        listaPanel.setBackground(new Color(200, 200, 200)); 
        listaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        //listaPanel.setBorder(new BordaRedonda(15));
    
        controller.listarAtividades(nomeUsuario, listaPanel);
        
        add(listaPanel);
        
    }
    
    

    
}
