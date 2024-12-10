package view;

import controller.DistribuirNotasProfessorController;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfaceDistribuirNotasProfessor extends JFrame {

    private DefaultTableModel tableModel;
    private DistribuirNotasProfessorController controller;

    public InterfaceDistribuirNotasProfessor(String nomeUsuario, DistribuirNotasProfessorController controller) {
        this.controller = controller;

        setTitle("Distribuir Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 1024);
        setLayout(null);

        setupHeader(nomeUsuario);
        setupTable(nomeUsuario);

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

        JLabel messageLabel = new JLabel("Notas Atividades", JLabel.CENTER);
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

    private void setupTable(String nomeUsuario) {

        String[] colunas = {"IdMateria", "Matéria", "Nome da Atividade", "Data de Entrega", "Nota"};
        tableModel = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(tableModel);

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
        scrollPane.setBounds(200, 150, 1000, 500); // Tamanho e posição do JScrollPane

        // Adiciona uma borda ao redor da tabela
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borda preta de 1px

        controller.carregarAtividades(nomeUsuario, tableModel);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    String nomeAtividade = (String) tabela.getValueAt(row, 2); // Nome da atividade
                    mostrarAlunos(nomeUsuario, nomeAtividade);
                }
            }
        });

        add(scrollPane);
        setVisible(true);
    }

    private void mostrarAlunos(String nomeUsuario, String nomeAtividade) {
        JFrame frame = new JFrame("Alunos que Respondem à Atividade");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        String[] colunas = {"Nome do Aluno", "Nota Atribuída"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabela);
        frame.add(scrollPane, BorderLayout.CENTER);

        controller.mostrarAlunos(nomeUsuario,nomeAtividade, tableModel);
        // Quando clicar em um aluno, exibe os detalhes e permite atribuir nota
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    String nomeAluno = (String) tabela.getValueAt(row, 0); // Nome do aluno
                    atribuirNota(nomeUsuario, nomeAtividade, nomeAluno);
                }
            }
        });

        frame.setVisible(true);
    }

    private JFrame atribuirNotaFrame = null;  // Definir a janela fora da função

    private void atribuirNota(String nomeUsuario, String nomeAtividade, String nomeAluno) {
        // Verifica se a janela de atribuição de nota já está aberta para o aluno
        if (atribuirNotaFrame != null) {
            atribuirNotaFrame.dispose();  // Se já estiver aberta, fecha a janela anterior
        }
    
        // Cria uma nova janela para atribuição de nota
        atribuirNotaFrame = new JFrame("Atribuir Nota ao Aluno");
        atribuirNotaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        atribuirNotaFrame.setSize(400, 300);
        atribuirNotaFrame.setLayout(new FlowLayout());
    
        JLabel notaLabel = new JLabel("Nota para " + nomeAluno + ": ");
        JTextField notaField = new JTextField(10);
        JButton atribuirButton = new JButton("Atribuir Nota");
    
        atribuirButton.addActionListener(e -> {
            String nota = notaField.getText();
            if (!nota.isEmpty()) {
                try {
                    double notaDouble = Double.parseDouble(nota);
                    controller.atribuirNota(nomeUsuario, nomeAtividade, nomeAluno, notaDouble);
                    JOptionPane.showMessageDialog(atribuirNotaFrame, "Nota atribuída com sucesso!");
                    atribuirNotaFrame.dispose();  // Fecha a janela depois de atribuir a nota
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(atribuirNotaFrame, "Por favor, insira um valor válido para a nota.");
                }
            } else {
                JOptionPane.showMessageDialog(atribuirNotaFrame, "Por favor, insira a nota.");
            }
        });
    
        atribuirNotaFrame.add(notaLabel);
        atribuirNotaFrame.add(notaField);
        atribuirNotaFrame.add(atribuirButton);
        atribuirNotaFrame.setVisible(true);
    }
    
}
