package view;

import controller.CadastrarUsuariosController;
import java.awt.*;
import javax.swing.*;

public class InterfaceCadastrarUsuariosAdministrador extends JFrame {

    private CadastrarUsuariosController controller;

    public InterfaceCadastrarUsuariosAdministrador(String nomeUsuario, CadastrarUsuariosController controller) {
        this.controller = controller;

        setTitle("Cadastrar Usuários!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

        setupHeader(nomeUsuario);
        setupForm();

        setVisible(true);
    }

    private void setupHeader(String nomeUsuario) {
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

        JLabel messageLabel = new JLabel("Cadastrar Usuários", JLabel.CENTER);
        messageLabel.setBounds(0, 80, 1440, 40);
        messageLabel.setFont(new Font("Cabin", Font.BOLD, 30));
        messageLabel.setForeground(Color.black);


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
        add(messageLabel);
    }

    private void setupForm() {
        // Labels para os campos de cadastro
        JLabel idUsuarioLabel = new JLabel("ID Usuário:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel usuarioLabel = new JLabel("Usuário:");
        JLabel senhaLabel = new JLabel("Senha:");
        JLabel identificacaoLabel = new JLabel("Identificação:");
        JLabel emailLabel = new JLabel("E-mail:");
        JLabel telefoneLabel = new JLabel("Telefone:");
        JLabel idCursoLabel = new JLabel("IdCurso:");
        JLabel cursoLabel = new JLabel("Curso:");
        JLabel idMateriaLabel = new JLabel("IdMateria:");
        JLabel materiaLabel = new JLabel("Materia:");

        idUsuarioLabel.setBounds(470, 160, 100, 30);
        nomeLabel.setBounds(470, 200, 100, 30);
        usuarioLabel.setBounds(470, 240, 100, 30);
        senhaLabel.setBounds(470, 280, 100, 30);
        identificacaoLabel.setBounds(470, 320, 100, 30);
        emailLabel.setBounds(470, 360, 100, 30);
        telefoneLabel.setBounds(470, 400, 100, 30);
        idCursoLabel.setBounds(470, 440, 100, 30);
        cursoLabel.setBounds(470, 480, 100, 30);
        idMateriaLabel.setBounds(470, 520, 100, 30);
        materiaLabel.setBounds(470, 560, 100, 30);

        // Campos de texto para os dados do usuário
        JTextField idUsuarioField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField usuarioField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JTextField identificacaoField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField idCursoField = new JTextField();
        JTextField cursoField = new JTextField();
        JTextField idMateriaField = new JTextField();
        JTextField materiaField = new JTextField();

        idUsuarioField.setBounds(580, 160, 300, 30);
        nomeField.setBounds(580, 200, 300, 30);
        usuarioField.setBounds(580, 240, 300, 30);
        senhaField.setBounds(580, 280, 300, 30);
        identificacaoField.setBounds(580, 320, 300, 30);
        emailField.setBounds(580, 360, 300, 30);
        telefoneField.setBounds(580, 400, 300, 30);
        idCursoField.setBounds(580, 440, 300, 30);
        cursoField.setBounds(580, 480, 300, 30);
        idMateriaField.setBounds(580, 520, 300, 30);
        materiaField.setBounds(580, 560, 300, 30);

        // Botão para cadastrar o usuário
        BotaoArredondado cadastrarButton = new BotaoArredondado("Cadastrar",15);
        cadastrarButton.setBounds(580, 600, 300, 40);
        cadastrarButton.setBackground(new Color(0, 51, 102)); // Azul escuro
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Cabin", Font.PLAIN, 18));

        cadastrarButton.addActionListener(e -> {
            controller.cadastrarUsuario(
                idUsuarioField.getText(),
                nomeField.getText(),
                usuarioField.getText(),
                new String(senhaField.getPassword()),
                identificacaoField.getText(),
                emailField.getText(),
                telefoneField.getText(),
                idCursoField.getText(),
                cursoField.getText(),
                idMateriaField.getText(),
                materiaField.getText()
            );
        });

        // Adiciona os componentes à janela
        add(idUsuarioLabel);
        add(nomeLabel);
        add(usuarioLabel);
        add(senhaLabel);
        add(identificacaoLabel);
        add(emailLabel);
        add(telefoneLabel);
        add(idCursoLabel);
        add(cursoLabel);
        add(idMateriaLabel);
        add(materiaLabel);
        add(idUsuarioField);
        add(nomeField);
        add(usuarioField);
        add(senhaField);
        add(identificacaoField);
        add(emailField);
        add(telefoneField);
        add(idCursoField);
        add(cursoField);
        add(idMateriaField);
        add(materiaField);
        add(cadastrarButton);

    }

}
