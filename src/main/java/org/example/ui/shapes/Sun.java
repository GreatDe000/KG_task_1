package org.example.ui.shapes;

import java.awt.*;

public class Sun {
    public void draw(Graphics2D g2, int w, int h) {
        g2.setColor(new Color(255, 240, 120));
        int sunSize = 120;
        g2.fillOval(w - sunSize - 40, 40, sunSize, sunSize);
    }
}
