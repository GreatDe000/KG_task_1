package org.example.ui.shapes;

import java.awt.*;

public class Cloud {

    // смещения по X (НЕ абсолютные координаты!)
    private double x1 = 0;
    private double x2 = 0;
    private double x3 = 0;
    private double x4 = 0;

    // скорости
    private final double v1 = 0.6;
    private final double v2 = 0.9;
    private final double v3 = 0.5;
    private final double v4 = 0.75;

    // базовые X (как у тебя были в рисовании)
    private final int base1 = 80;
    private final int base2 = 350;
    private final int base3 = 520;
    private final int base4 = 180;

    // примерные ширины “композиций” облаков
    private final int W1 = 260;
    private final int W2 = 280;
    private final int W3 = 180;
    private final int W4 = 260;

    public void update(int w) {
        if (w <= 0) return;

        x1 += v1;
        x2 += v2;
        x3 += v3;
        x4 += v4;

        // переносим только когда левый край облака ушёл за правую границу
        if (base1 + x1 > w) x1 = -(base1 + W1);
        if (base2 + x2 > w) x2 = -(base2 + W2);
        if (base3 + x3 > w) x3 = -(base3 + W3);
        if (base4 + x4 > w) x4 = -(base4 + W4);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);

        // облако 1
        g2.fillOval(base1 + (int)x1, 120, 120, 60);
        g2.fillOval(base1 + 60 + (int)x1, 100, 140, 80);
        g2.fillOval(base1 + 120 + (int)x1, 120, 120, 60);

        // облако 2
        g2.fillOval(base2 + (int)x2, 80, 130, 65);
        g2.fillOval(base2 + 50 + (int)x2, 60, 150, 85);
        g2.fillOval(base2 + 120 + (int)x2, 80, 130, 65);

        // облако 3
        g2.fillOval(base3 + (int)x3, 150, 100, 50);
        g2.fillOval(base3 + 40 + (int)x3, 135, 110, 55);

        // облако 4 (новое)
        g2.fillOval(base4 + (int)x4, 60, 110, 55);
        g2.fillOval(base4 + 55 + (int)x4, 45, 135, 70);
        g2.fillOval(base4 + 130 + (int)x4, 60, 110, 55);
    }
}
