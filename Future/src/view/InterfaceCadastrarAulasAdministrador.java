package view;

import controller.CadastrarAulasController;
import java.awt.*;
import javax.swing.*;

public class InterfaceCadastrarAulasAdministrador extends JFrame {  // Aqui estamos estendendo JFrame
    private CadastrarAulasController controller;

    public InterfaceCadastrarAulasAdministrador(String nomeUsuario, CadastrarAulasController controller) {
        this.controller = controller;

        // Configurações do JFrame
        setTitle("Cadastro de Aulas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

        setupHeader(nomeUsuario);
        setupForm();

        setVisible(true);  // Exibe a janela
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

        JLabel messageLabel = new JLabel("Cadastrar Aulas", JLabel.CENTER);
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
            dispose();  // Fecha a janela
            controller.voltar(nomeUsuario);
        });

        headerPanel.add(voltarButton);
        add(headerPanel);  // Adiciona o painel ao JFrame
        add(messageLabel);
    }

    private void setupForm() {
        // Labels para os campos de cadastro
        JLabel idMateriaLabel = new JLabel("ID Matéria:");
        JLabel materiaLabel = new JLabel("Matéria:");
        JLabel horarioInicioLabel = new JLabel("Horário Início:");
        JLabel horarioFimLabel = new JLabel("Horário Fim:");
        JLabel diaLabel = new JLabel("Dia:");
        JLabel periodoLabel = new JLabel("Período:");
        JLabel linkSaladeAulaLabel = new JLabel("Link Aula:");

        idMateriaLabel.setBounds(470, 160, 100, 30);
        materiaLabel.setBounds(470, 200, 100, 30);
        horarioInicioLabel.setBounds(470, 240, 100, 30);
        horarioFimLabel.setBounds(470, 280, 100, 30);
        diaLabel.setBounds(470, 320, 100, 30);
        periodoLabel.setBounds(470, 360, 100, 30);
        linkSaladeAulaLabel.setBounds(470, 400, 100, 30);

        // Campos de texto para os dados da aula
        JTextField idMateriaField = new JTextField();
        JTextField materiaField = new JTextField();
        JTextField horarioInicioField = new JTextField();
        JTextField horarioFimField = new JTextField();
        JTextField diaField = new JTextField();
        JTextField periodoField = new JTextField();
        JTextField linkSaladeAulaField = new JTextField();

        idMateriaField.setBounds(580, 160, 300, 30);
        materiaField.setBounds(580, 200, 300, 30);
        horarioInicioField.setBounds(580, 240, 300, 30);
        horarioFimField.setBounds(580, 280, 300, 30);
        diaField.setBounds(580, 320, 300, 30);
        periodoField.setBounds(580, 360, 300, 30);
        linkSaladeAulaField.setBounds(580, 400, 300, 30);

        // Botão para cadastrar a aula
        BotaoArredondado cadastrarButton = new BotaoArredondado("Cadastrar",15);
        cadastrarButton.setBounds(580, 440, 300, 40);
        cadastrarButton.setBackground(new Color(0, 51, 102));  // Azul escuro
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Cabin", Font.PLAIN, 18));

        // Ação do botão "Cadastrar"

        cadastrarButton.addActionListener(e -> {
            String idMateria = idMateriaField.getText();
            String materia = materiaField.getText();
            String horarioInicio = horarioInicioField.getText();
            String horarioFim = horarioFimField.getText();
            String dia = diaField.getText();
            String periodo = periodoField.getText();
            String linkSaladeAula = linkSaladeAulaField.getText();

            if (idMateria.isEmpty() || materia.isEmpty() || horarioInicio.isEmpty() || horarioFim.isEmpty() || dia.isEmpty() || periodo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                controller.cadastrarAula(idMateria, materia, horarioInicio, horarioFim, dia, periodo, linkSaladeAula);
            }
        });

        

        // Adiciona os componentes à janela
        add(idMateriaLabel);
        add(materiaLabel);
        add(horarioInicioLabel);
        add(horarioFimLabel);
        add(diaLabel);
        add(periodoLabel);
        add(linkSaladeAulaLabel);
        add(idMateriaField);
        add(materiaField);
        add(horarioInicioField);
        add(horarioFimField);
        add(diaField);
        add(periodoField);
        add(linkSaladeAulaField);
        add(cadastrarButton);
        
    }
}
