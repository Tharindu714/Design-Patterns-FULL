package com.tharindu.oodp2.Flyweight.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ForestSimGUI extends JFrame {
    public ForestSimGUI() {
        super("Flyweight Forest & Dino Simulator");
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ForestPanel panel = new ForestPanel();
        getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();  // Only pack now, before making visible

        // ESC to exit
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
            }
        });

        new SwingWorker<Void, JLabel>() {
            private final Random rand = new Random();
            private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            final int targetOaks = 50;
            final int targetPines = 50;
            final int targetDins = 10;

            private int oaksPlanted = 0;
            private int pinesPlanted = 0;
            private int dinsPlanted = 0;

            @Override
            protected Void doInBackground() {
                System.out.println("\n--- Planting World ---");
                while (oaksPlanted < targetOaks
                        || pinesPlanted < targetPines
                        || dinsPlanted < targetDins) {

                    int x = rand.nextInt(screen.width);
                    int y = rand.nextInt(screen.height);

                    if (oaksPlanted < targetOaks && tryPlant(x, y, "Oak", "🌳")) {
                        oaksPlanted++;
                        System.out.println("Oak #" + oaksPlanted + " planted at (" + x + ", " + y + ")");
                    }
                    if (pinesPlanted < targetPines && tryPlant(x, y, "Pine", "🌲")) {
                        pinesPlanted++;
                        System.out.println("Pine #" + pinesPlanted + " planted at (" + x + ", " + y + ")");
                    }
                    if (dinsPlanted < targetDins && tryPlant(x, y, "Dino", "🦖")) {
                        dinsPlanted++;
                        System.out.println("Dino #" + dinsPlanted + " planted at (" + x + ", " + y + ")");
                    }
                }
                return null;
            }

            private boolean tryPlant(int x, int y, String name, String emoji) {
                for (Point p : panel.occupied) {
                    if (p.distance(x, y) < ForestPanel.MIN_DIST) {
                        return false;
                    }
                }
                panel.occupied.add(new Point(x, y));
                EntityType type = EntityFactory.getEntityType(name, emoji);
                JLabel lbl = type.createLabel(x, y);
                publish(lbl);
                return true;
            }

            @Override
            protected void process(List<JLabel> chunks) {
                for (JLabel lbl : chunks) {
                    panel.add(lbl);
                }
                panel.revalidate();
                panel.repaint();
            }

            @Override
            protected void done() {
                System.out.println("--- World Ready ---");
                System.out.println("Oak trees created: "   + oaksPlanted);
                System.out.println("Pine trees created: "  + pinesPlanted);
                System.out.println("Dinosaurs hatched: "   + dinsPlanted + " (click to hatch more!)\n");
            }
        }.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ForestSimGUI app = new ForestSimGUI();
            app.setVisible(true);  // Now panel size is usable!
        });
    }
}