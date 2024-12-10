package view;

import controller.ProfessorInicialController;
import java.awt.*;
import javax.swing.*;
import model.UsuarioModel;

public class InterfaceInicialProfessor extends JFrame {
    private JButton salaDeAulaButton, atividadesButton, distribuirNotasButton, encaminharAvisosButton, membrosMateriaButton, visualizarAtividadesButton;

    public InterfaceInicialProfessor(String nomeUsuario) {
        super("Tela Principal - Professor");  // Chama o construtor JFrame com o título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

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

        JLabel messageLabel = new JLabel(nomeUsuario + ", bem-vindo(a) ao Future cursos!");
        messageLabel.setBounds(30, 80, 1000, 40);
        messageLabel.setFont(new Font("Cabin", Font.BOLD, 30));
        messageLabel.setForeground(Color.black);

        JPanel linhaSeparadora = new JPanel();
        linhaSeparadora.setBounds(0, 130, 1440, 2); // Largura total da interface e altura de 2px
        linhaSeparadora.setBackground(Color.GRAY); // Define a cor cinza para a linha
        add(linhaSeparadora); // Adiciona o painel da linha ao JFrame

        BotaoArredondado voltarButton = new BotaoArredondado("Sair",15);
        voltarButton.setBounds(20, 20, 100, 30);

        // Define a cor de fundo com um vermelho mais suave
        voltarButton.setBackground(new Color(211, 47, 47)); // Vermelho suave (RGB: 211, 47, 47)

        // Define a cor do texto do botão como branco
        voltarButton.setForeground(Color.WHITE);

        // Define a fonte do botão
        voltarButton.setFont(new Font("Cabin", Font.BOLD, 16));

        voltarButton.addActionListener(e -> {
            dispose();
            ProfessorInicialController controller = new ProfessorInicialController(this, new UsuarioModel(nomeUsuario, ""));
            controller.voltar();
        });

        headerPanel.add(voltarButton);
        
        // Inicializa os botões
        inicializarBotoes();

        // Tamanho maior para os botões
        int larguraBotao = 500;
        int alturaBotao = 120;

        // Calcula o centro da tela
        int larguraTela = 1440;
        int alturaTela = 1024;

        // Calculando as posições dos botões para duas colunas e três linhas
        int espacoHorizontal = (larguraTela - 2 * larguraBotao) / 3; // Espaço entre as colunas
        int espacoVertical = (alturaTela - 3 * alturaBotao) / 4; // Espaço entre as linhas

        // Configurações para os botões (centralizados na tela)
        configurarBotao(salaDeAulaButton, espacoHorizontal, espacoVertical, larguraBotao, alturaBotao);
        configurarBotao(atividadesButton, espacoHorizontal, espacoVertical + alturaBotao + 10, larguraBotao, alturaBotao);
        configurarBotao(distribuirNotasButton, espacoHorizontal, espacoVertical + 2 * (alturaBotao + 10), larguraBotao, alturaBotao);

        configurarBotao(encaminharAvisosButton, espacoHorizontal + larguraBotao + espacoHorizontal, espacoVertical, larguraBotao, alturaBotao);
        configurarBotao(membrosMateriaButton, espacoHorizontal + larguraBotao + espacoHorizontal, espacoVertical + alturaBotao + 10, larguraBotao, alturaBotao);
        configurarBotao(visualizarAtividadesButton, espacoHorizontal + larguraBotao + espacoHorizontal, espacoVertical + 2 * (alturaBotao + 10), larguraBotao, alturaBotao);

        // Adiciona os componentes na tela
        add(headerPanel);
        add(messageLabel);
        add(salaDeAulaButton);
        add(atividadesButton);
        add(distribuirNotasButton);
        add(encaminharAvisosButton);
        add(membrosMateriaButton);
        add(visualizarAtividadesButton);

        new ProfessorInicialController(this, new UsuarioModel(nomeUsuario, "")); // Passar a senha como vazio ou de onde você obtém

        // Exibe a janela
        setVisible(true);
    }

    private void inicializarBotoes() {
        
        salaDeAulaButton = new BotaoArredondado("Sala de Aula",15);
        atividadesButton = new BotaoArredondado("Atividades",15);
        distribuirNotasButton = new BotaoArredondado("Distribuir Notas",15);
        encaminharAvisosButton = new BotaoArredondado("Encaminhar Avisos",15);
        membrosMateriaButton = new BotaoArredondado("Membros Materia",15);
        visualizarAtividadesButton = new BotaoArredondado("Visualizar Atividades",15);
    }

    private void configurarBotao(JButton botao, int x, int y, int largura, int altura) {
        botao.setBounds(x, y, largura, altura);
        botao.setBackground(new Color(0, 51, 102)); // Azul escuro
        botao.setForeground(Color.WHITE); // Cor do texto do botão
        botao.setFont(new Font("Cabin", Font.PLAIN, 30)); // Fonte maior
    }

    public void adicionarAcaoSalaDeAula(java.awt.event.ActionListener acao) {
        salaDeAulaButton.addActionListener(acao);
    }

    public void adicionarAcaoAtividades(java.awt.event.ActionListener acao) {
        atividadesButton.addActionListener(acao);
    }

    public void adicionarAcaoDistribuirNotas(java.awt.event.ActionListener acao) {
        distribuirNotasButton.addActionListener(acao);
    }

    public void adicionarAcaoEncaminharAvisos(java.awt.event.ActionListener acao) {
        encaminharAvisosButton.addActionListener(acao);
    }

    public void adicionarAcaoMembrosMateria(java.awt.event.ActionListener acao) {
        membrosMateriaButton.addActionListener(acao);
    }

    public void adicionarAcaoVisualizarAtividades(java.awt.event.ActionListener acao) {
        visualizarAtividadesButton.addActionListener(acao);
    }

    public JFrame getFrame() {
        return this; // Retorna a própria instância de JFrame
    }

    public static void main(String[] args) {
        // Exemplo de como passar o nome do usuário
        String nomeUsuario = "Usuario"; // Pode vir de um login ou de outro lugar
        new InterfaceInicialProfessor(nomeUsuario);
    }
}
