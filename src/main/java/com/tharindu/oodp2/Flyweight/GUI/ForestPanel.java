package com.tharindu.oodp2.Flyweight.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

// ----- GUI Panel to Render World -----
public class ForestPanel extends JPanel {
    static final int MIN_DIST = 20;  // minimal spacing in pixels
    final List<Point> occupied = new ArrayList<>();

    ForestPanel() {
        setBackground(new Color(10, 30, 10));  // dark forest green
        setLayout(null);                       // absolute positioning
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        // click anywhere to hatch a dino (if enough space)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (plantEntityAtRuntime(e.getX(), e.getY(), "Dino", "🦖")) {
                    revalidate();
                    repaint();
                }
            }
        });
    }

    /**
     * Used at runtime (e.g., on user click) — adds JLabel directly
     */
    public boolean plantEntityAtRuntime(int x, int y, String name, String emoji) {
        for (Point p : occupied) {
            if (p.distance(x, y) < MIN_DIST) {
                return false;
            }
        }
        occupied.add(new Point(x, y));
        EntityType type = EntityFactory.getEntityType(name, emoji);
        JLabel lbl = type.createLabel(x, y);
        add(lbl);
        return true;
    }
}
