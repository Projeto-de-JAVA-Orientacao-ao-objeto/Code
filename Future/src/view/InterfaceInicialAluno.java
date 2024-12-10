package view;

import controller.*;
import java.awt.*;
import javax.swing.*;
import model.UsuarioModel;


public class InterfaceInicialAluno extends JFrame {

    private JButton assistirAulasButton, enviarAtividadesButton, visualizarNotasButton, membrosSalaButton, gradeHorariosButton, avisosButton;


    public InterfaceInicialAluno(String nomeUsuario) {
        // Definir o título da janela e outras propriedades
        super("Tela Principal - Aluno");
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

        // Botão "Voltar"
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
            AlunoInicialController controller = new AlunoInicialController(this, new UsuarioModel(nomeUsuario, ""));
            controller.voltar();
        });

        headerPanel.add(voltarButton);

        // Inicializa os botões
        inicializarBotoes();

        int larguraBotao = 500;
        int alturaBotao = 120;

        // Calcula o centro da tela
        int larguraTela = 1440;
        int alturaTela = 1024;

        // Calculando as posições dos botões para duas colunas e três linhas
        int espacoHorizontal = (larguraTela - 2 * larguraBotao) / 3; // Espaço entre as colunas
        int espacoVertical = (alturaTela - 3 * alturaBotao) / 4; // Espaço entre as linhas

        // Configurações para os botões (centralizados na tela)
        configurarBotao(assistirAulasButton, espacoHorizontal, espacoVertical, larguraBotao, alturaBotao);
        configurarBotao(enviarAtividadesButton, espacoHorizontal, espacoVertical + alturaBotao + 10, larguraBotao, alturaBotao);
        configurarBotao(visualizarNotasButton, espacoHorizontal, espacoVertical + 2 * (alturaBotao + 10), larguraBotao, alturaBotao);

        configurarBotao(membrosSalaButton, espacoHorizontal + larguraBotao + espacoHorizontal, espacoVertical, larguraBotao, alturaBotao);
        configurarBotao(gradeHorariosButton, espacoHorizontal + larguraBotao + espacoHorizontal, espacoVertical + alturaBotao + 10, larguraBotao, alturaBotao);
        configurarBotao(avisosButton, espacoHorizontal + larguraBotao + espacoHorizontal, espacoVertical + 2 * (alturaBotao + 10), larguraBotao, alturaBotao);


        // Adiciona os componentes à janela
        add(headerPanel);
        add(messageLabel);
        add(assistirAulasButton);
        add(enviarAtividadesButton);
        add(visualizarNotasButton);
        add(membrosSalaButton);
        add(gradeHorariosButton);
        add(avisosButton);



        new AlunoInicialController(this, new UsuarioModel(nomeUsuario, ""));

        // Exibe a janela principal
        setVisible(true);
    }

    private void inicializarBotoes() {
        
        assistirAulasButton = new BotaoArredondado("Assistir Aulas", 15);
        enviarAtividadesButton = new BotaoArredondado("Quadro de Atividades", 15);
        visualizarNotasButton = new BotaoArredondado("Visualizar Notas", 15);
        membrosSalaButton = new BotaoArredondado("Membros Materia", 15);
        gradeHorariosButton = new BotaoArredondado("Grade de Horários", 15);
        avisosButton = new BotaoArredondado("Avisos", 15);
    }

    private void configurarBotao(JButton botao, int x, int y, int largura, int altura) {
        botao.setBounds(x, y, largura, altura);
        botao.setBackground(new Color(0, 51, 102)); // Azul escuro
        botao.setForeground(Color.WHITE); // Cor do texto do botão
        botao.setFont(new Font("Cabin", Font.PLAIN, 30)); // Fonte maior
    }

    // Métodos para adicionar ações aos botões
    public void adicionarAcaoAssistirAulas(java.awt.event.ActionListener acao) {
        assistirAulasButton.addActionListener(acao);
    }

    public void adicionarAcaoEnviarAtividades(java.awt.event.ActionListener acao) {
        enviarAtividadesButton.addActionListener(acao);
    }

    public void adicionarAcaoVisualizarNotas(java.awt.event.ActionListener acao) {
        visualizarNotasButton.addActionListener(acao);
    }

    public void adicionarMembrosSala(java.awt.event.ActionListener acao) {
        membrosSalaButton.addActionListener(acao);
    }

    public void adicionarAcaoGradeHorarios(java.awt.event.ActionListener acao) {
        gradeHorariosButton.addActionListener(acao);
    }

    public void adicionarAcaoAvisos(java.awt.event.ActionListener acao) {
        avisosButton.addActionListener(acao);
    }

    // Método para acessar o JFrame
    public JFrame getFrame() {
        return this; // Retorna a própria instância de JFrame
    }

    public static void main(String[] args) {
        // Passando o nome do usuário para a tela
        String nomeUsuario = "João"; // Pode ser o nome do usuário autenticado
        new InterfaceInicialAluno(nomeUsuario);
    }
}
