package org.example.ui;

import javax.swing.*;

public class SceneFrame extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 900;

    public SceneFrame() {
        setTitle("Сцена — земля как на рисунке");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(WIDTH, HEIGHT);
        setResizable(false);         // нельзя растягивать/уменьшать
        setLocationRelativeTo(null); // центр экрана

        add(new ScenePanel());

        setVisible(true);
    }
}
