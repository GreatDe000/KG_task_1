package org.example.ui.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Bush {

    private int x, y;
    private double scale;

    public Bush(int x, int y, double scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(60, 160, 70));

        g2.fill(new Ellipse2D.Double(x, y, 60 * scale, 35 * scale));
        g2.fill(new Ellipse2D.Double(x + 25 * scale, y - 10 * scale, 70 * scale, 45 * scale));
        g2.fill(new Ellipse2D.Double(x + 60 * scale, y, 60 * scale, 35 * scale));
    }
}
