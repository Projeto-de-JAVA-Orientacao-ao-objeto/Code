package view;

import controller.CadastrarCursosController;
import java.awt.*;
import javax.swing.*;

public class InterfaceCadastrarCursosAdministrador extends JFrame {

    private CadastrarCursosController controller;

    public InterfaceCadastrarCursosAdministrador(String nomeUsuario, CadastrarCursosController controller) {
        this.controller = controller;

        setTitle("Cadastrar Cursos!");
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

        JLabel messageLabel = new JLabel("Cadastrar Cursos", JLabel.CENTER);
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
        JLabel idCursoLabel = new JLabel("ID Curso:");
        JLabel idMateriaLabel = new JLabel("ID Matéria:");
        JLabel cursoLabel = new JLabel("Curso:");
        JLabel materiaLabel = new JLabel("Matéria:");
        JLabel moduloLabel = new JLabel("Módulo:");

        idCursoLabel.setBounds(470, 160, 100, 30);
        idMateriaLabel.setBounds(470, 200, 100, 30);
        cursoLabel.setBounds(470, 240, 100, 30);
        materiaLabel.setBounds(470, 280, 100, 30);
        moduloLabel.setBounds(470, 320, 100, 30);

        // Campos de texto
        JTextField idCursoField = new JTextField();
        JTextField idMateriaField = new JTextField();
        JTextField cursoField = new JTextField();
        JTextField materiaField = new JTextField();
        JTextField moduloField = new JTextField();

        idCursoField.setBounds(580, 160, 300, 30);
        idMateriaField.setBounds(580, 200, 300, 30);
        cursoField.setBounds(580, 240, 300, 30);
        materiaField.setBounds(580, 280, 300, 30);
        moduloField.setBounds(580, 320, 300, 30);

        BotaoArredondado cadastrarButton = new BotaoArredondado("Cadastrar",15);
        cadastrarButton.setBounds(580, 360, 300, 40);
        cadastrarButton.setBackground(new Color(0, 51, 102));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Cabin", Font.PLAIN, 18));

        cadastrarButton.addActionListener(e -> {
            String idCurso = idCursoField.getText();
            String idMateria = idMateriaField.getText();
            String curso = cursoField.getText();
            String materia = materiaField.getText();
            String modulo = moduloField.getText();

            if (idCurso.isEmpty() || idMateria.isEmpty() || curso.isEmpty() || materia.isEmpty() || modulo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                controller.cadastrarCurso(idCurso, idMateria, curso, materia, modulo);
            }
        });


        add(idCursoLabel);
        add(idMateriaLabel);
        add(cursoLabel);
        add(materiaLabel);
        add(moduloLabel);
        add(idCursoField);
        add(idMateriaField);
        add(cursoField);
        add(materiaField);
        add(moduloField);
        add(cadastrarButton);

    }

}
