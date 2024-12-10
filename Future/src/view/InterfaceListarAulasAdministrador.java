package view;

import controller.ListarAulasController;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfaceListarAulasAdministrador extends JFrame {

    private DefaultTableModel model;
    private ListarAulasController controller;

    public InterfaceListarAulasAdministrador(String nomeCurso, ListarAulasController controller) {
        this.controller = controller;

        setTitle("Lista de Aulas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

        setupHeader(nomeCurso);
        setupTable();

        setVisible(true);
    }

    private void setupHeader(String nomeCurso) {
        // Cria um painel para o gradiente
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
            controller.voltar(nomeCurso);
        });

        headerPanel.add(logoLabel);
        headerPanel.add(voltarButton);

        JLabel messageLabel = new JLabel("Lista de aulas cadastradas", JLabel.CENTER);
        messageLabel.setBounds(0, 80, 1440, 40);
        messageLabel.setFont(new Font("Cabin", Font.BOLD, 30));
        messageLabel.setForeground(Color.black);


        JPanel linhaSeparadora = new JPanel();
        linhaSeparadora.setBounds(0, 130, 1440, 2); // Largura total da interface e altura de 2px
        linhaSeparadora.setBackground(Color.GRAY); // Define a cor cinza para a linha
        add(linhaSeparadora); // Adiciona o painel da linha ao JFrame

        add(headerPanel);
        add(messageLabel);
    }

    private void setupTable() {

        String[] colunas = {"IdMateria", "Materia", "HorarioInicio", "HorarioFim", "Dia", "Periodo", "LinkSala"};
        model = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(model);

        // Configuração da tabela (células)
        tabela.setBackground(new Color(240, 240, 240)); // Cor do plano de fundo das células
        tabela.setForeground(Color.black); // Cor do texto nas células
        tabela.setFont(new Font("Cabin", Font.PLAIN, 14)); // Fonte das células
        tabela.setRowHeight(25); // Altura das linhas

        // Configuração da grade
        tabela.setGridColor(Color.BLACK); // Cor da grade
        tabela.setIntercellSpacing(new Dimension(1, 1)); // Define o tamanho da grade (1px entre células)

        // Configuração do cabeçalho da tabela
        tabela.getTableHeader().setBackground(new Color(217, 217, 217)); // Fundo do cabeçalho
        tabela.getTableHeader().setForeground(Color.BLACK); // Cor do texto do cabeçalho
        tabela.getTableHeader().setFont(new Font("Cabin", Font.BOLD, 16)); // Fonte do cabeçalho

        // Configuração para exibir grades no cabeçalho
        tabela.setShowHorizontalLines(true); // Exibe as linhas horizontais
        tabela.setShowVerticalLines(true);   // Exibe as linhas verticais

        // Configuração do JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(80, 170, 1220, 500); // Tamanho e posição do JScrollPane

        // Adiciona uma borda ao redor da tabela
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borda preta de 1px

        add(scrollPane);

        // Popula a tabela com os dados
        controller.listarAulas(model);
    }

}
