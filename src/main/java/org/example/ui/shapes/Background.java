package org.example.ui.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Небо + холмы (фон). Вынесено в отдельный класс.
 */
public class Background {

    private final Color skyColor = new Color(135, 206, 235);
    private final Color hillBack = new Color(45, 120, 40);
    private final Color hillMid = new Color(70, 150, 60);
    private final Color hillFront = new Color(90, 200, 80);

    public void draw(Graphics2D g2, int w, int h) {
        // небо
        g2.setColor(skyColor);
        g2.fillRect(0, 0, w, h);

        // холмы (примерно как на референсе)
        g2.setColor(hillMid);
        g2.fill(new Ellipse2D.Double(-200, h - 290, 1200, 400));

        g2.setColor(hillBack);
        g2.fill(new Ellipse2D.Double(-700, h - 300, 1100, 380));

        g2.setColor(hillFront);
        g2.fill(new Ellipse2D.Double(-330, h - 180, 1000, 300));
    }
}
