package view;

import controller.AvisosProfessorController;
import java.awt.*;
import javax.swing.*;
import model.AvisosProfessorModel;

public class InterfaceAvisosProfessor extends JFrame {
    private AvisosProfessorController controller;

    public InterfaceAvisosProfessor(String nomeUsuario, AvisosProfessorController controller) {
        this.controller = new AvisosProfessorController();

        setTitle("Inserir Aviso");
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

        AvisosProfessorModel professorData = controller.buscarDadosProfessor(nomeUsuario);

        if (professorData != null) {
            JLabel idMateriaLabel = new JLabel("ID da Matéria: " + professorData.getIdMateria());
            idMateriaLabel.setBounds(50, 100, 500, 30);
            idMateriaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

            JLabel materiaLabel = new JLabel("Matéria: " + professorData.getMateria());
            materiaLabel.setBounds(50, 140, 500, 30);
            materiaLabel.setFont(new Font("Cabin", Font.BOLD, 20));

            JLabel professorLabel = new JLabel("Professor: " + professorData.getProfessor());
            professorLabel.setBounds(50, 180, 500, 30);
            professorLabel.setFont(new Font("Cabin", Font.BOLD, 20));

            JLabel tituloLabel = new JLabel("Título do Aviso:");
            tituloLabel.setBounds(50, 240, 500, 30);
            tituloLabel.setFont(new Font("Cabin", Font.BOLD, 20));

            JTextField tituloField = new JTextField();
            tituloField.setBounds(260, 240, 300, 30);

            JLabel avisoLabel = new JLabel("Aviso:");
            avisoLabel.setBounds(50, 290, 500, 30);
            avisoLabel.setFont(new Font("Cabin", Font.BOLD, 20));

            JTextArea avisoArea = new JTextArea();
            avisoArea.setBounds(260, 290, 600, 200);
            avisoArea.setLineWrap(true);
            avisoArea.setWrapStyleWord(true);

            BotaoArredondado salvarButton = new BotaoArredondado("Enviar Aviso", 15);
            salvarButton.setBounds(50, 520, 200, 40);
            salvarButton.setBackground(new Color(0, 51, 102));
            salvarButton.setForeground(Color.WHITE);
            salvarButton.setFont(new Font("Cabin", Font.BOLD, 18));

            salvarButton.addActionListener(e -> {
                // Cria o objeto AvisosProfessorModel com os dados necessários
                AvisosProfessorModel aviso = new AvisosProfessorModel();
                aviso.setIdMateria(professorData.getIdMateria()); 
                aviso.setMateria(professorData.getMateria()); 
                aviso.setProfessor(professorData.getProfessor());
                aviso.setTitulo(tituloField.getText());  // Pega o texto do campo de título
                aviso.setTexto(avisoArea.getText());     // Pega o texto da área de aviso
            
                // Chama o método inserirAviso
                boolean sucesso = controller.inserirAviso(aviso, tituloField.getText(), avisoArea.getText());
            
                if (sucesso) {
                    JOptionPane.showMessageDialog(this, "Aviso inserido com sucesso!");
                    tituloField.setText("");
                    avisoArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir o aviso.");
                }
            });
            

            add(idMateriaLabel);
            add(materiaLabel);
            add(professorLabel);
            add(tituloLabel);
            add(tituloField);
            add(avisoLabel);
            add(avisoArea);
            add(salvarButton);
        } else {
            JLabel errorLabel = new JLabel("Não foi possível recuperar os dados do professor.", JLabel.CENTER);
            errorLabel.setBounds(0, 70, 1440, 40);
            errorLabel.setFont(new Font("Arial", Font.BOLD, 30));
            errorLabel.setForeground(Color.RED);
            add(errorLabel);
        }

        setVisible(true);
    }
}
