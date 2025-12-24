package org.example.ui;

import org.example.ui.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ScenePanel extends JPanel {

    private Sun sun = new Sun();
    private Cloud clouds = new Cloud();

    private Tree tree1 = new Tree(200, 600, 1.0);
    private Tree tree2 = new Tree(380, 620, 1.3);
    private Tree tree3 = new Tree(525, 590, 0.9);

    private Boy boy = new Boy(240, 530, 1.2);

    // точка руки
    private Kite kite = new Kite(
            (int) (280 + 68 * 1.2),
            (int) (490 + 55 * 1.2),
            1.2
    );

    private Bush bush1 = new Bush(0, 670, 1.1);
    private Bush bush2 = new Bush(460, 750, 1.3);

    private Butterfly butterfly1 = new Butterfly(180, 460, 1.0);
    private Butterfly butterfly2 = new Butterfly(620, 510, 0.9);

    private Timer animationTimer;

    public ScenePanel() {

        animationTimer = new Timer(30, e -> {
            clouds.update(getWidth());

            butterfly1.update(getWidth());
            butterfly2.update(getWidth());

            kite.update();

            repaint();
        });

        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // небо
        g2.setColor(new Color(135, 206, 235));
        g2.fillRect(0, 0, w, h);

        // фон
        sun.draw(g2, w, h);
        clouds.draw(g2);

        tree1.draw(g2);
        tree2.draw(g2);
        tree3.draw(g2);

        // холмы
        g2.setColor(new Color(70, 150, 60));
        g2.fill(new Ellipse2D.Double(-200, h - 290, 1200, 400));

        g2.setColor(new Color(45, 120, 40));
        g2.fill(new Ellipse2D.Double(-700, h - 300, 1100, 380));

        g2.setColor(new Color(90, 200, 80));
        g2.fill(new Ellipse2D.Double(-330, h - 180, 1000, 300));

        // передний план
        boy.draw(g2);
        kite.draw(g2);

        bush1.draw(g2);
        bush2.draw(g2);

        butterfly1.draw(g2);
        butterfly2.draw(g2);
    }
}
