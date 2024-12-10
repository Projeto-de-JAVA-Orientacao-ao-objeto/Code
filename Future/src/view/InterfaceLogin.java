package view;

import controller.LoginController;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import observer.LoginStatusObserver;
import service.AutenticacaoService;

public class InterfaceLogin {
    private JFrame frame;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public InterfaceLogin() {
        // Janela principal
        frame = new JFrame("Login");
        frame.setSize(1440, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Painel de fundo com gradiente
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Define o gradiente (de azul escuro para azul claro)
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 51, 102), getWidth(), getHeight(), new Color(112, 128, 144));

                // Aplica o gradiente no fundo
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel); // Define o painel de fundo com gradiente

        ImageIcon future =new ImageIcon("Logo/Logo.png");
        JLabel futureLabel = new JLabel(future);
        futureLabel.setBounds((frame.getWidth() - 200) / 2, 100, 500, 200); // Centralizado no topo
        backgroundPanel.add(futureLabel);

        // Painel de login
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Fundo arredondado
            }
        };
        loginPanel.setBounds(47, 175, 300, 400);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setOpaque(false);
        loginPanel.setLayout(null);

        // Título "Login"
        JLabel loginTitle = new JLabel("Login");
        loginTitle.setFont(new Font("Cabin", Font.BOLD, 24));
        loginTitle.setBounds(0, 30, loginPanel.getWidth(), 40);
        loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(loginTitle);

        // Campo de login
        loginField = new JTextField("Digite seu login");
        loginField.setBounds(30, 100, 240, 30);
        loginField.setFont(new Font("Cabin", Font.PLAIN, 14));
        loginField.setForeground(Color.GRAY);
        loginField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
        loginField.setOpaque(false);
        loginField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (loginField.getText().equals("Digite seu login")) {
                    loginField.setText("");
                    loginField.setForeground(Color.BLACK);
                }
                loginField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (loginField.getText().isEmpty()) {
                    loginField.setText("Digite seu login");
                    loginField.setForeground(Color.GRAY);
                }
                loginField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
            }
        });
        loginPanel.add(loginField);

        // Campo de senha
        passwordField = new JPasswordField("Digite sua senha");
        passwordField.setBounds(30, 150, 240, 30);
        passwordField.setFont(new Font("Cabin", Font.PLAIN, 14));
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
        passwordField.setOpaque(false);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Digite sua senha")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                    passwordField.setForeground(Color.BLACK);
                }
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Digite sua senha");
                    passwordField.setEchoChar((char) 0);
                    passwordField.setForeground(Color.GRAY);
                }
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
            }
        });
        loginPanel.add(passwordField);

        // Botão "Entrar"
        loginButton = new JButton("ENTRAR") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 51, 102));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(Color.WHITE);
                FontMetrics fm = g2.getFontMetrics();
                int textWidth = fm.stringWidth(getText());
                int textHeight = fm.getAscent();
                g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 3);
            }
        };
        loginButton.setBounds(30, 215, 240, 40);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Cabin", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginPanel.add(loginButton);

        // Botão "Esqueci minha senha?"
        JLabel forgotPasswordLabel = new JLabel("Esqueceu sua senha?");
        forgotPasswordLabel.setBounds(150, 185, 240, 20); // Posicionamento abaixo do campo de senha
        forgotPasswordLabel.setForeground(Color.GRAY);
        forgotPasswordLabel.setFont(new Font("Cabin", Font.PLAIN, 12));
        loginPanel.add(forgotPasswordLabel);

        // Adiciona o painel de login à janela
        backgroundPanel.add(loginPanel);

        // Exibe a janela
        frame.setVisible(true);

        // Inicialize as dependências e o controller aqui
        AutenticacaoService authService = new AutenticacaoService();
        LoginController loginController = new LoginController(this, authService);
        LoginStatusObserver statusObserver = new LoginStatusObserver();
        loginController.addObserver(statusObserver);
    }

    public String getUsername() {
        return loginField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
