package org.example.ui.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Boy {

    private int x;
    private int y;
    private double scale;

    public Boy(int x, int y, double scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void draw(Graphics2D g2) {

        g2.setStroke(new BasicStroke((float)(6 * scale)));

        // Голова
        g2.setColor(new Color(255, 205, 170));
        g2.fill(new Ellipse2D.Double(
                x + 22 * scale, y,
                44 * scale, 44 * scale
        ));

        // Кепка
        g2.setColor(new Color(220, 60, 60));
        // верх
        g2.fill(new Ellipse2D.Double(
                x + 20 * scale, y - 6 * scale,
                48 * scale, 26 * scale
        ));
        // козырёк назад
        g2.fill(new RoundRectangle2D.Double(
                x + 8 * scale, y + 8 * scale,
                18 * scale, 10 * scale,
                10, 10
        ));

        // тело
        g2.setColor(new Color(50, 130, 210));
        g2.fill(new RoundRectangle2D.Double(
                x + 20 * scale, y + 42 * scale,
                50 * scale, 50 * scale,
                25, 25
        ));

        // шорты
        g2.setColor(new Color(235, 90, 70));
        g2.fill(new RoundRectangle2D.Double(
                x + 22 * scale, y + 88 * scale,
                46 * scale, 24 * scale,
                15, 15
        ));

        // Левая рука
        g2.setColor(new Color(255, 205, 170));
        g2.drawLine(
                (int)(x + 68 * scale), (int)(y + 55 * scale),
                (int)(x + 100 * scale), (int)(y + 20 * scale)
        );

        // правая рука
        g2.drawLine(
                (int)(x + 22 * scale), (int)(y + 55 * scale),
                (int)(x + 10 * scale), (int)(y + 95 * scale)
        );

        // ноги
        g2.fill(new RoundRectangle2D.Double(
                x + 26 * scale, y + 112 * scale,
                12 * scale, 40 * scale,
                10, 10
        ));
        g2.fill(new RoundRectangle2D.Double(
                x + 50 * scale, y + 112 * scale,
                12 * scale, 40 * scale,
                10, 10
        ));

        // обувь
        g2.setColor(new Color(60, 60, 60));
        g2.fill(new RoundRectangle2D.Double(
                x + 22 * scale, y + 150 * scale,
                20 * scale, 8 * scale,
                10, 10
        ));
        g2.fill(new RoundRectangle2D.Double(
                x + 46 * scale, y + 150 * scale,
                20 * scale, 8 * scale,
                10, 10
        ));
    }
}
