package org.example.ui;

import org.example.ui.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScenePanel extends JPanel {

    private static final Random RND = new Random();

    private final Background background = new Background();

    private Sun sun;

    private final Boy boy = new Boy(240, 530, 1.2);

    private final Kite kite = new Kite(
            (int) (280 + 68 * 1.2),
            (int) (490 + 55 * 1.2),
            1.2
    );

    // --- ВАЖНО: списки объектов сцены ---
    // ДЕРЕВЬЯ И КУСТЫ — ФИКСИРОВАННЫЕ.
    // 👉 Меняй КОЛИЧЕСТВО и КООРДИНАТЫ ТОЛЬКО в методах buildFixedTrees()/buildFixedBushes().
    private final List<Tree> trees = new ArrayList<>();
    private final List<Bush> bushes = new ArrayList<>();
    private final List<Cloud> clouds = new ArrayList<>();
    private final List<Butterfly> butterflies = new ArrayList<>();

    private boolean generated = false;
    private final Timer animationTimer;

    public ScenePanel() {
        // фиксированные объекты (координаты задаёшь сам здесь через buildFixedTrees()/buildFixedBushes())
        trees.addAll(buildFixedTrees());
        bushes.addAll(buildFixedBushes());

        animationTimer = new Timer(30, e -> {
            int w = getWidth();

            // каждое облако — отдельный экземпляр со своим update()
            for (Cloud cloud : clouds) {
                cloud.update(w);
            }
            for (Butterfly butterfly : butterflies) {
                butterfly.update(w);
            }

            kite.update();
            repaint();
        });

        animationTimer.start();
    }

    /**
     * Фиксированные деревья.
     *
     * ✅ Здесь ты задаёшь:
     *  - количество деревьев (сколько строк new Tree(...))
     *  - координаты (x, y)
     *  - масштаб (scale)
     */
    private List<Tree> buildFixedTrees() {
        List<Tree> result = new ArrayList<>();

        // TODO: задай свои координаты/масштабы
        // Пример (замени/добавь/удали строки как нужно):
        result.add(new Tree(350, 600, 1.0));
        result.add(new Tree(520, 610, 1.2));
        result.add(new Tree(200, 600, 0.9));
        result.add(new Tree(100, 600, 1.2));

        return result;
    }

    /**
     * Фиксированные кусты.
     *
     * ✅ Здесь ты задаёшь:
     *  - количество кустов (сколько строк new Bush(...))
     *  - координаты (x, y)
     *  - масштаб (scale)
     */
    private List<Bush> buildFixedBushes() {
        List<Bush> result = new ArrayList<>();

        // TODO: задай свои координаты/масштабы
        // Пример (замени/добавь/удали строки как нужно):
        result.add(new Bush(120, 590, 1.0));
        result.add(new Bush(450, 750, 1.4));
        result.add(new Bush(50, 680, 1.4));
        result.add(new Bush(350, 570, 1.2));

        return result;
    }

    /**
     * Генерируем объекты сцены, когда панель уже получила размеры.
     */
    private void generateIfNeeded() {
        if (generated) {
            return;
        }
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }

        clouds.clear();
        butterflies.clear();

        // солнце (координаты задаём при создании)
        int sunSize = 120;
        sun = new Sun(Math.max(0, w - sunSize - 40), 40, sunSize);

        // Деревья и кусты — фиксированные: задаются вручную в buildFixedTrees()/buildFixedBushes().

        // облака: каждый экземпляр со своим y/скоростью/масштабом
        int cloudsCount = 4 + RND.nextInt(5); // 4..8
        for (int i = 0; i < cloudsCount; i++) {
            double x = RND.nextInt(w);
            int y = 40 + RND.nextInt(170);
            double s = 0.55 + RND.nextDouble() * 0.8;
            double vx = 0.25 + RND.nextDouble() * 1.2;
            clouds.add(new Cloud(x, y, s, vx));
        }

        // бабочки
        int butterfliesCount = 2 + RND.nextInt(3); // 2..4
        for (int i = 0; i < butterfliesCount; i++) {
            int x = 80 + RND.nextInt(Math.max(1, w - 160));
            int y = (int) (h * 0.55) + RND.nextInt(140);
            double s = 0.8 + RND.nextDouble() * 0.6;
            butterflies.add(new Butterfly(x, y, s));
        }

        generated = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        generateIfNeeded();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // фон
        background.draw(g2, w, h);
        if (sun != null) {
            sun.draw(g2);
        }

        for (Cloud cloud : clouds) {
            cloud.draw(g2);
        }

        for (Tree tree : trees) {
            tree.draw(g2);
        }

        // передний план
        boy.draw(g2);
        kite.draw(g2);

        for (Bush bush : bushes) {
            bush.draw(g2);
        }

        for (Butterfly butterfly : butterflies) {
            butterfly.draw(g2);
        }
    }
}
