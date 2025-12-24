package org.example.ui.shapes;

import java.awt.*;
import java.awt.geom.Path2D;

public class Kite {

    private double swing = 0;

    public void update() {
        swing += 0.05;
    }


    private int x;      // точка, откуда идёт нить
    private int y;
    private double scale;

    public Kite(int x, int y, double scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {

        // ---------- СМЕЩЕНИЕ ЗМЕЯ ОТ ТОЧКИ ----------
        int offsetX = (int)(Math.sin(swing) * 15);
        int offsetY = (int)(Math.cos(swing) * 10);

        int kiteX = (int)(x + 80 * scale + offsetX);
        int kiteY = (int)(y - 160 * scale + offsetY);


        // ---------- НИТЬ ----------
        g2.setColor(new Color(40, 90, 70));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(x, y, kiteX, kiteY);

        // ---------- ТЕЛО ЗМЕЯ (ромб) ----------
        Path2D body = new Path2D.Double();
        body.moveTo(kiteX, kiteY - 22 * scale);
        body.lineTo(kiteX + 22 * scale, kiteY);
        body.lineTo(kiteX, kiteY + 22 * scale);
        body.lineTo(kiteX - 22 * scale, kiteY);
        body.closePath();

        g2.setColor(new Color(245, 200, 80));
        g2.fill(body);

        // ---------- ЦВЕТНОЙ СЕКТОР ----------
        g2.setColor(new Color(220, 80, 60));
        g2.fillPolygon(
                new int[]{
                        kiteX,
                        (int)(kiteX + 22 * scale),
                        kiteX
                },
                new int[]{
                        kiteY,
                        (int)(kiteY + 22 * scale),
                        kiteY
                },
                3
        );

        // ---------- ХВОСТ ----------
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(
                kiteX,
                (int)(kiteY + 22 * scale),
                (int)(kiteX + 15 * scale),
                (int)(kiteY + 55 * scale)
        );
        g2.drawLine(
                (int)(kiteX + 15 * scale),
                (int)(kiteY + 55 * scale),
                (int)(kiteX - 10 * scale),
                (int)(kiteY + 85 * scale)
        );
    }
}
