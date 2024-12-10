package view;

import controller.AtividadeProfessorController;
import java.awt.*;
import javax.swing.*;
import model.AtividadeProfessorModel;

public class InterfaceAtividadeProfessor extends JFrame {
    private AtividadeProfessorController controller;

    public InterfaceAtividadeProfessor(String nomeUsuario, AtividadeProfessorController controller) {
        this.controller = controller; 

        // Configuração da interface
        setTitle("Inserir Atividade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null); // O layout nulo está sendo mantido aqui conforme sua implementação original

        // Header com informações do usuário
        JPanel headerPanel = criarHeader(nomeUsuario);
        add(headerPanel);  // Adiciona o painel de cabeçalho à janela

        // Busca os dados do professor
        AtividadeProfessorModel professorData = controller.buscarDadosProfessor(nomeUsuario);

        if (professorData != null) {
            criarFormulario(professorData); // Passa os dados para criar o formulário
        } else {
            JLabel errorLabel = new JLabel("Não foi possível recuperar os dados do professor.", JLabel.CENTER);
            errorLabel.setBounds(0, 70, 1440, 40);
            errorLabel.setFont(new Font("Arial", Font.BOLD, 30));
            errorLabel.setForeground(Color.RED);
            add(errorLabel);
        }

        setVisible(true);
    }

    private JPanel criarHeader(String nomeUsuario) {
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Criação do gradiente
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 51, 102), getWidth() + 200, 0, new Color(112, 128, 144));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight()); // Preenche o painel com o gradiente
            }
        };

        headerPanel.setBounds(0, 0, 1440, 70);
        headerPanel.setLayout(null);

        // Logo
        ImageIcon logoIcon = new ImageIcon("Logo/Logo.png");
        Image logoImage = logoIcon.getImage();
        Image scaledLogo = logoImage.getScaledInstance(320, 60, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaledLogo);

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(1000, 5, 320, 60); 
        headerPanel.add(logoLabel);

        // Botão "Voltar"
        BotaoArredondado voltarButton = new BotaoArredondado("Voltar", 15);
        voltarButton.setBounds(20, 20, 100, 30);
        voltarButton.setBackground(new Color(211, 47, 47));
        voltarButton.setForeground(Color.WHITE);
        voltarButton.setFont(new Font("Cabin", Font.BOLD, 16));

        voltarButton.addActionListener(e -> {
            dispose(); // Fecha a janela atual
            controller.voltarParaTelaInicial(nomeUsuario); // Chama o método de voltar
        });

        headerPanel.add(voltarButton);
        return headerPanel;
    }

    private void criarFormulario(AtividadeProfessorModel professorData) {
        JLabel idMateriaLabel = new JLabel("ID da Matéria: " + professorData.getIdMateria());
        idMateriaLabel.setBounds(50, 100, 500, 30);
        idMateriaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JLabel materiaLabel = new JLabel("Matéria: " + professorData.getMateria());
        materiaLabel.setBounds(50, 140, 500, 30);
        materiaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JLabel professorLabel = new JLabel("Professor: " + professorData.getProfessor());
        professorLabel.setBounds(50, 180, 500, 30);
        professorLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JLabel atividadeLabel = new JLabel("Nome da Atividade:");
        atividadeLabel.setBounds(50, 240, 200, 30);
        atividadeLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JTextField atividadeField = new JTextField();
        atividadeField.setBounds(260, 240, 300, 30);

        JLabel perguntaLabel = new JLabel("Pergunta:");
        perguntaLabel.setBounds(50, 290, 200, 30);
        perguntaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JTextArea perguntaArea = new JTextArea();
        perguntaArea.setBounds(260, 290, 600, 100);
        perguntaArea.setLineWrap(true);
        perguntaArea.setWrapStyleWord(true);

        JLabel dataEntregaLabel = new JLabel("Data de Entrega:");
        dataEntregaLabel.setBounds(50, 410, 250, 30);
        dataEntregaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JTextField dataEntregaField = new JTextField();
        dataEntregaField.setBounds(260, 410, 200, 30);

        JLabel notaLabel = new JLabel("Nota:");
        notaLabel.setBounds(50, 460, 200, 30);
        notaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

        JTextField notaField = new JTextField();
        notaField.setBounds(260, 460, 200, 30);

        BotaoArredondado salvarButton = new BotaoArredondado("Enviar Atividade", 15);
        salvarButton.setBounds(50, 520, 200, 40);
        salvarButton.setBackground(new Color(0, 51, 102));
        salvarButton.setForeground(Color.WHITE);
        salvarButton.setFont(new Font("Cabin", Font.BOLD, 18));

        salvarButton.addActionListener(e -> {
            AtividadeProfessorModel atividade = new AtividadeProfessorModel(
                    professorData.getIdMateria(),
                    professorData.getMateria(),
                    professorData.getProfessor(),
                    atividadeField.getText(),
                    perguntaArea.getText(),
                    dataEntregaField.getText(),
                    notaField.getText()
            );
            if (controller.salvarAtividade(atividade)) {
                JOptionPane.showMessageDialog(this, "Atividade inserida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir a atividade.");
            }
        });

        add(idMateriaLabel);
        add(materiaLabel);
        add(professorLabel);
        add(atividadeLabel);
        add(atividadeField);
        add(perguntaLabel);
        add(perguntaArea);
        add(dataEntregaLabel);
        add(dataEntregaField);
        add(notaLabel);
        add(notaField);
        add(salvarButton);
    }
}
