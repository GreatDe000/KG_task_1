package org.example.ui.shapes;

import java.awt.*;

/**
 * Одно облако. Каждый экземпляр имеет свои координаты и скорость.
 */
public class Cloud {

    private double x;
    private final int y;
    private final double scale;
    private final double vx;

    // приблизительная ширина облака, чтобы понимать когда оно полностью ушло
    private final int approxWidth;

    public Cloud(double x, int y, double scale, double vx) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.vx = vx;
        this.approxWidth = (int) (280 * scale);
    }

    public void update(int panelWidth) {
        x += vx;
        if (panelWidth <= 0) {
            return;
        }

        // если облако полностью ушло за правую границу — переносим влево
        if (x - approxWidth > panelWidth) {
            x = -approxWidth;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);

        int xi = (int) x;
        int w1 = (int) (120 * scale);
        int h1 = (int) (60 * scale);

        // 3 «пузыря» как простое облачко
        g2.fillOval(xi, y, w1, h1);
        g2.fillOval(xi + (int) (55 * scale), y - (int) (20 * scale), (int) (150 * scale), (int) (85 * scale));
        g2.fillOval(xi + (int) (140 * scale), y, (int) (120 * scale), (int) (60 * scale));
    }
}
