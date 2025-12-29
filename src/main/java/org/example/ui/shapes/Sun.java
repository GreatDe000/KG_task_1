package org.example.ui.shapes;

import java.awt.*;

/**
 * Простое солнце.
 * Координаты задаются при создании (как и у деревьев/кустов).
 */
public class Sun {

    private final int x;
    private final int y;
    private final int size;

    public Sun(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(255, 240, 120));
        g2.fillOval(x, y, size, size);
    }
}
