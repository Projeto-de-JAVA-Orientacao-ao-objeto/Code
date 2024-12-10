package view;

import java.awt.*;
import javax.swing.*;

public class BotaoArredondado extends JButton {
    private int radius;

    public BotaoArredondado(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define a cor de fundo
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Define a cor da borda (opcional)
        //g2d.setColor(getForeground());
        //g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

        g2d.dispose();
        super.paintComponent(g);
    }
}

