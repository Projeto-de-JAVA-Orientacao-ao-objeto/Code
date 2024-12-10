package view;

import controller.GradeHorariosAlunoController;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class InterfaceGradeHorariosAluno extends JFrame {

    private DefaultTableModel model;
    private GradeHorariosAlunoController controller;
    private String nomeAluno; // Campo para armazenar nomeAluno

    public InterfaceGradeHorariosAluno(String nomeAluno, GradeHorariosAlunoController controller) {
        this.nomeAluno = nomeAluno; // Inicialize nomeAluno aqui
        this.controller = controller;

        setTitle("Grade de Horários do Aluno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

        setupHeader();
        setupTable();

        setVisible(true);
    }

    private void setupHeader() {
        // Usar nomeAluno diretamente, pois já está disponível como campo
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 51, 102), getWidth() + 200, 0, new Color(112, 128, 144));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        headerPanel.setBounds(0, 0, 1440, 70);
        headerPanel.setLayout(null);

        JLabel logoLabel = new JLabel(new ImageIcon("Logo/Logo.png"));
        logoLabel.setBounds(1000, 5, 320, 60);
        headerPanel.add(logoLabel);

        BotaoArredondado voltarButton = new BotaoArredondado("Voltar", 15);
        voltarButton.setBounds(20, 20, 100, 30);
        voltarButton.setBackground(new Color(211, 47, 47));
        voltarButton.setForeground(Color.WHITE);
        voltarButton.setFont(new Font("Cabin", Font.BOLD, 16));
        voltarButton.addActionListener(e -> {
            dispose();
            controller.voltar(nomeAluno); // Usando nomeAluno
        });
        headerPanel.add(voltarButton);

        JLabel messageLabel = new JLabel("Grade de Horários", JLabel.CENTER);
        messageLabel.setBounds(0, 80, 1440, 40);
        messageLabel.setFont(new Font("Cabin", Font.BOLD, 30));
        messageLabel.setForeground(Color.black);

        JPanel linhaSeparadora = new JPanel();
        linhaSeparadora.setBounds(0, 130, 1440, 2);
        linhaSeparadora.setBackground(Color.GRAY);
        add(linhaSeparadora);

        add(headerPanel);
        add(messageLabel);
    }

    private void setupTable() {
        String[] colunas = {"Dia", "Matéria", "Início", "Fim"};
        model = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(model);
        tabela.setBackground(new Color(240, 240, 240));
        tabela.setForeground(Color.black);
        tabela.setFont(new Font("Cabin", Font.PLAIN, 14));
        tabela.setRowHeight(25);
        tabela.setGridColor(Color.BLACK);
        tabela.setIntercellSpacing(new Dimension(1, 1));
        tabela.getTableHeader().setBackground(new Color(217, 217, 217));
        tabela.getTableHeader().setForeground(Color.BLACK);
        tabela.getTableHeader().setFont(new Font("Cabin", Font.BOLD, 16));
        tabela.setShowHorizontalLines(true);
        tabela.setShowVerticalLines(true);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(80, 170, 1220, 500);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(scrollPane);

        controller.listarGradeHorarios(model, nomeAluno); // Agora nomeAluno está disponível
    }
}
