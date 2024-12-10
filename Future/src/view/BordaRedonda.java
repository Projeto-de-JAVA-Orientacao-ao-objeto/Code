package view;

import java.awt.*;
import javax.swing.*;

public class BordaRedonda extends JPanel {
    private int radius; // Raio dos cantos arredondados

    public BordaRedonda(int radius) {
        this.radius = radius;
        setOpaque(false); // Deixa o fundo transparente para o efeito arredondado funcionar
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define a cor de fundo do painel
        g2d.setColor(getBackground());

        // Preenche o painel com cantos arredondados
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2d.dispose(); // Libera os recursos gráficos
    }
}
