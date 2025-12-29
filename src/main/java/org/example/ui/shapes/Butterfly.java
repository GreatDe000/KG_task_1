package org.example.ui.shapes;

import java.awt.*;
import java.util.Random;

public class Butterfly {

    private static final Random RND = new Random();

    private int baseY;
    private double x;
    private double scale;

    // движение
    private double vx;
    private double t = 0;

    // рандомная траектория по Y
    private double amp1, amp2;      // амплитуды
    private double f1, f2;          // частоты
    private double phase1, phase2;  // фазы

    public Butterfly(int x, int y, double scale) {
        this.x = x;
        this.baseY = y;
        this.scale = scale;

        // скорость
        this.vx = 1.5 + RND.nextDouble() * 2.0;

        // параметры случайной траектории
        randomizePathALittle();
    }

    public void update(int panelWidth) {
        t += 1;
        x += vx;

        // границы с небольшим отступом
        double left = 0;
        double right = panelWidth - 30 * scale;

        if (x < left) {
            x = left;
            vx = Math.abs(vx); // вправо
            randomizePathALittle();
        } else if (x > right) {
            x = right;
            vx = -Math.abs(vx); // влево
            randomizePathALittle();
        }
    }

    // На развороте меняет траекторию
    private void randomizePathALittle() {
        amp1 = 6 + RND.nextDouble() * 10;
        amp2 = 3 + RND.nextDouble() * 8;
        f1 = 0.06 + RND.nextDouble() * 0.06;
        f2 = 0.10 + RND.nextDouble() * 0.10;
        phase1 = RND.nextDouble() * Math.PI * 2;
        phase2 = RND.nextDouble() * Math.PI * 2;
    }

    public void draw(Graphics2D g2) {

        int y = (int) (baseY
                + Math.sin(t * f1 + phase1) * amp1
                + Math.sin(t * f2 + phase2) * amp2);

        int xi = (int) x;

        // крылья
        g2.setColor(new Color(245, 160, 60));
        g2.fillOval(
                (int)(xi - 14 * scale), (int)(y - 8 * scale),
                (int)(18 * scale), (int)(14 * scale)
        );
        g2.fillOval(
                (int)(xi + 2 * scale), (int)(y - 8 * scale),
                (int)(18 * scale), (int)(14 * scale)
        );

        // тело
        g2.setColor(Color.DARK_GRAY);
        g2.fillOval(
                (int)(xi - 2 * scale), (int)(y - 8 * scale),
                (int)(4 * scale), (int)(16 * scale)
        );
    }
}
