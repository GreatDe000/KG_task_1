package org.example.ui.shapes;

import java.awt.*;

public class Tree {

    private int x;
    private int y;
    private double scale;

    public Tree(int x, int y, double scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void draw(Graphics2D g2) {

        // ---- СТВОЛ ----
        g2.setColor(new Color(120, 80, 50)); // коричневый
        int trunkWidth = (int)(25 * scale);
        int trunkHeight = (int)(60 * scale);

        g2.fillRect(
                x - trunkWidth / 2,
                y - trunkHeight,
                trunkWidth,
                trunkHeight
        );

        // ---- КРОНА — 3 одинаковых треугольника ----
        g2.setColor(new Color(30, 140, 30)); // зелёный как на рисунке

        int triWidth = (int)(140 * scale);   // ширина треугольника
        int triHeight = (int)(90 * scale);   // высота треугольника

        // Нижний
        drawTriangle(g2,
                x, y - trunkHeight - 0,
                triWidth, triHeight
        );

        // Средний
        drawTriangle(g2,
                x, y - trunkHeight - (int)(triHeight * 0.7),
                triWidth, triHeight
        );

        // Верхний
        drawTriangle(g2,
                x, y - trunkHeight - (int)(triHeight * 1.4),
                triWidth, triHeight
        );
    }

    /** Рисует равнобедренный треугольник */
    private void drawTriangle(Graphics2D g2, int centerX, int baseY, int width, int height) {
        int half = width / 2;

        int[] xPoints = {
                centerX - half, // левый
                centerX + half, // правый
                centerX         // верхушка
        };

        int[] yPoints = {
                baseY,          // низ
                baseY,          // низ
                baseY - height  // вершина
        };

        g2.fillPolygon(xPoints, yPoints, 3);
    }
}
